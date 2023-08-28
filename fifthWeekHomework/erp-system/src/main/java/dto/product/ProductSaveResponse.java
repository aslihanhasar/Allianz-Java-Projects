package main.java.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductSaveResponse {
    private Long id;
    private String name;
    private String priceInformation;
    private boolean inStock;
}
