package main.java.dto.order;

import main.java.dto.orderItem.OrderItemSaveResponse;
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
public class OrderSaveResponse {
    private Long id;
    private String customerNameSurname;
    private OrderStatus orderStatus;
    private List<OrderItemSaveResponse> orderItems;
}
