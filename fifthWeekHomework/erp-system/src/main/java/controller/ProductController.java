package main.java.controller;

import main.java.dto.BaseResponse;
import main.java.dto.product.ProductSaveRequest;
import main.java.dto.product.ProductSaveResponse;
import main.java.dto.product.ProductUpdateRequest;
import main.java.entity.Product;
import main.java.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<BaseResponse<ProductSaveResponse>> createProduct
            (@RequestBody ProductSaveRequest productSaveRequest) {
        ProductSaveResponse productSaveResponse = productService.save(productSaveRequest);
         var response=BaseResponse.<ProductSaveResponse>builder()
                .status(HttpStatus.CREATED.value())
                .isSuccess(true)
                .data(productSaveResponse)
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<BaseResponse<ProductSaveResponse>> updateProduct
            (@RequestBody ProductUpdateRequest productUpdateRequest) {
        ProductSaveResponse productSaveResponse = productService.update(productUpdateRequest);
        var response = BaseResponse.<ProductSaveResponse>builder()
                .status(HttpStatus.CREATED.value())
                .isSuccess(true)
                .data(productSaveResponse)
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{uuid}")
    public void deleteProduct(@PathVariable("uuid") UUID uuid) {
        productService.delete(uuid);
    }
}


