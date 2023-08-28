package main.java.dto.orderItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemUpdateRequest {
    private Long id;
    private int quantity;
    private double unitPrice;
}
