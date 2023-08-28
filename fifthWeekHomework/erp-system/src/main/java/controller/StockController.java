package main.java.controller;

import main.java.dto.StockDTO;
import main.java.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/{stockId}")
    public ResponseEntity<StockDTO> getStock(@PathVariable Long stockId) {
        StockDTO stockDTO = stockService.getStockById(stockId);
        return ResponseEntity.ok(stockDTO);
    }

    @GetMapping
    public ResponseEntity<List<StockDTO>> getAllStocks() {
        List<StockDTO> stocks = stockService.getAllStocks();
        return ResponseEntity.ok(stocks);
    }

    @PostMapping
    public ResponseEntity<StockDTO> saveStock(@RequestBody StockDTO stockDTO) {
        StockDTO savedStock = stockService.saveStock(stockDTO);
        return ResponseEntity.ok(savedStock);
    }

    @PutMapping
    public ResponseEntity<StockDTO> updateStock(@RequestBody StockDTO stockDTO) {
        StockDTO updatedStock = stockService.updateStock(stockDTO);
        return ResponseEntity.ok(updatedStock);
    }

    @DeleteMapping("/{stockId}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long stockId) {
        stockService.deleteStock(stockId);
        return ResponseEntity.noContent().build();
    }
}


