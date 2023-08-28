package main.java.controller;

import main.java.dto.BaseResponse;
import main.java.dto.orderItem.OrderItemSaveRequest;
import main.java.dto.orderItem.OrderItemSaveResponse;
import main.java.dto.orderItem.OrderItemUpdateRequest;
import main.java.entity.OrderItem;
import main.java.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/order-items")
@RequiredArgsConstructor
public class OrderItemController {

    private final OrderItemService orderItemService;

    @GetMapping()
    public ResponseEntity<List<OrderItem>> getOrderItems() {
        List<OrderItem> orderItems = orderItemService.getAllOrderItems();
        return ResponseEntity.ok(orderItems);
    }

    @PostMapping
    public ResponseEntity<BaseResponse<OrderItemSaveResponse>> createOrderItem
            (@RequestBody OrderItemSaveRequest orderItemSaveRequest) {
        OrderItemSaveResponse orderItemSaveResponse = orderItemService.save(orderItemSaveRequest);
        var response = BaseResponse.<OrderItemSaveResponse>builder()
                .status(HttpStatus.CREATED.value())
                .isSuccess(true)
                .data(orderItemSaveResponse)
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<BaseResponse<OrderItemSaveResponse>> updateOrderItem
            (@RequestBody OrderItemUpdateRequest orderItemUpdateRequest) {
        OrderItemSaveResponse orderItemSaveResponse = orderItemService.update(orderItemUpdateRequest);
        var response = BaseResponse.<OrderItemSaveResponse>builder()
                .status(HttpStatus.CREATED.value())
                .isSuccess(true)
                .data(orderItemSaveResponse)
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{uuid}")
    public void deleteOrderItem(@PathVariable("uuid") UUID uuid) {
        orderItemService.delete(uuid);
    }
}


