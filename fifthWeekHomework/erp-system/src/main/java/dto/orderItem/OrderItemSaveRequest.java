package main.java.dto.orderItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OrderItemSaveRequest {
    private Long orderId;
    private Long productId;
    private int quantity;
    private double unitPrice;
}