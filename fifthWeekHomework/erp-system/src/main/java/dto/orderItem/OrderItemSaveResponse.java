package main.java.dto.orderItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemSaveResponse {
    private Long id;
    private Long orderId;
    private String productName;
    private int quantity;
    private double unitPrice;
    private double totalPrice;
}
