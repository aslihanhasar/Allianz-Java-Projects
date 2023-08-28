package main.java.dto.order;

import main.java.dto.orderItem.OrderItemUpdateRequest;
import main.java.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderUpdateRequest {
    private Long id;
    private OrderStatus orderStatus;
    private List<OrderItemUpdateRequest> orderItems;
}
