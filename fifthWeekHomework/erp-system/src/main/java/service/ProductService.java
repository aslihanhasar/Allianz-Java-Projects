package main.java.service;

import main.java.dto.product.ProductSaveRequest;
import main.java.dto.product.ProductSaveResponse;
import main.java.dto.product.ProductUpdateRequest;
import main.java.entity.Product;
import main.java.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Saves a new product based on the provided `ProductSaveRequest`.
     *
     * @param productSaveRequest The request object containing product data to be saved.
     * @return A response object containing the saved product's information.
     * @throws RuntimeException if a product with the same name already exists.
     */
    @Transactional
    public ProductSaveResponse save(ProductSaveRequest productSaveRequest) {
        checkIsProductAlreadySaved(productSaveRequest);
        Product savedCustomer = buildProductAndSave(productSaveRequest);
        return convertProductToResponse(savedCustomer);
    }

    /**
     * Retrieves a list of all products currently stored in the system.
     *
     * @return A list of all product records.
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Retrieves a reference to a product by its ID without fully loading its data.
     *
     * @param id The ID of the product to retrieve.
     * @return A reference to the product.
     */
    public Product getReferenceById(Long id) {
        return productRepository.getReferenceById(id);
    }

    /**
     * Updates an existing product's information based on the provided `ProductUpdateRequest`.
     *
     * @param productUpdateRequest The request object containing updated product data.
     * @return A response object containing the updated product's information.
     * @throws RuntimeException if the specified product does not exist.
     */
    public ProductSaveResponse update(ProductUpdateRequest productUpdateRequest) {
        Optional<Product> productOptional = productRepository.findById(productUpdateRequest.getId());
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productUpdateRequest.getName());
            product.setPrice(productUpdateRequest.getPrice());
            product.setIncludesVAT(productUpdateRequest.isIncludesVAT());
            product.setInStock(product.isInStock());
            Product savedProduct = productRepository.save(product);
            return convertProductToResponse(savedProduct);
        }
        throw new RuntimeException("Product not found");
    }

    /**
     * Deletes a product by marking it as inactive and removing it from the database.
     *
     * @param uuid The UUID of the product to delete.
     * @throws RuntimeException if the specified product does not exist.
     */
    @Transactional
    public void delete(UUID uuid) {
        Product product = getProductByUUID(uuid);
        if (product != null) {
            productRepository.save(product);
            productRepository.deleteById(product.getId());
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    /**
     * Retrieves a product by its UUID.
     *
     * @param uuid The UUID of the product to retrieve.
     * @return The product object if found, or null if not found.
     */
    public Product getProductByUUID(UUID uuid) {
        Optional<Product> productOptional = productRepository.findProductByUuid(uuid);
        return productOptional.orElse(null);
    }

    private Product buildProductAndSave(ProductSaveRequest productSaveRequest) {
        Product newProduct = Product
                .builder()
                .name(productSaveRequest.getName())
                .price(productSaveRequest.getPrice())
                .includesVAT(productSaveRequest.isIncludesVAT())
                .inStock(productSaveRequest.isInStock())
                .build();
        return productRepository.save(newProduct);
    }

    private ProductSaveResponse convertProductToResponse(Product product) {
        return ProductSaveResponse
                .builder()
                .id(product.getId())
                .name(product.getName())
                .priceInformation(product.getPrice() + " - VAT Included: " + product.isIncludesVAT())
                .inStock(Boolean.parseBoolean("In stock: " + product.isInStock()))
                .build();
    }

    private void checkIsProductAlreadySaved(ProductSaveRequest productSaveRequest) {
        int productCountByName = productRepository.findProductCountByName(productSaveRequest.getName());
        if (productCountByName > 0) {
            throw new RuntimeException("The title is already exist");
        }
    }
}
