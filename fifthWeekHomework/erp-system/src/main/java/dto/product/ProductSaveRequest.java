package main.java.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductSaveRequest {
    private String name;
    private double price;
    private boolean includesVAT;
    private boolean inStock;
}
