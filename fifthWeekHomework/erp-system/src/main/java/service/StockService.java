package main.java.service;

import main.java.dto.StockDTO;
import main.java.entity.Product;
import main.java.entity.Stock;
import main.java.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;

    /**
     * Retrieves stock information by its ID.
     *
     * @param stockId The ID of the stock to retrieve.
     * @return A DTO object containing the stock's information.
     * @throws RuntimeException if the stock with the specified ID is not found.
     */
    public StockDTO getStockById(Long stockId) {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new RuntimeException("Stock not found with id: " + stockId));
        return convertToDTO(stock);
    }

    /**
     * Retrieves stock information by the product's ID.
     *
     * @param id The ID of the product to retrieve stock information for.
     * @return The stock object associated with the product.
     * @throws RuntimeException if stock information for the specified product is not found.
     */
    public Stock getStockByProductId(Long id) {
        return stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found"));
    }

    /**
     * Retrieves a list of all stocks currently stored in the system.
     *
     * @return A list of DTO objects containing stock records.
     */
    public List<StockDTO> getAllStocks() {
        List<Stock> stocks = stockRepository.findAll();
        return stocks.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    /**
     * Saves a new stock based on the provided `StockDTO`.
     *
     * @param stockDTO The DTO object containing stock data to be saved.
     * @return A DTO object containing the saved stock's information.
     */
    public StockDTO saveStock(StockDTO stockDTO) {
        Stock stock = convertToEntity(stockDTO);
        Stock savedStock = stockRepository.save(stock);
        return convertToDTO(savedStock);
    }

    /**
     * Updates an existing stock's information based on the provided `StockDTO`.
     *
     * @param stockDTO The DTO object containing updated stock data.
     * @return A DTO object containing the updated stock's information.
     * @throws RuntimeException if the specified stock does not exist.
     */
    public StockDTO updateStock(StockDTO stockDTO) {
        Stock stock = stockRepository.findById(stockDTO.getId())
                .orElseThrow(() -> new RuntimeException("Stock not found with id: " + stockDTO.getId()));
        stock.setId(stockDTO.getProductId());
        stock.setQuantity(stockDTO.getQuantity());
        Stock updatedStock = stockRepository.save(stock);
        return convertToDTO(updatedStock);
    }

    /**
     * Deletes a stock by removing it from the database.
     *
     * @param stockId The ID of the stock to delete.
     * @throws RuntimeException if the specified stock does not exist.
     */
    public void deleteStock(Long stockId) {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new RuntimeException("Stock not found with id: " + stockId));
        stockRepository.delete(stock);
    }

    private StockDTO convertToDTO(Stock stock) {
        return StockDTO.builder()
                .id(stock.getId())
                .productId(stock.getProduct().getId())
                .quantity(stock.getQuantity())
                .build();
    }

    private Stock convertToEntity(StockDTO stockDTO) {
        Product product = new Product();
        product.setId(stockDTO.getProductId());

        return Stock.builder()
                .id(stockDTO.getId())
                .product(product)
                .quantity(stockDTO.getQuantity())
                .build();
    }
}
