package main.java.service;

import main.java.dto.orderItem.OrderItemSaveRequest;
import main.java.dto.orderItem.OrderItemSaveResponse;
import main.java.dto.orderItem.OrderItemUpdateRequest;
import main.java.entity.Order;
import main.java.entity.OrderItem;
import main.java.entity.Product;
import main.java.repository.OrderItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final OrderService orderService;
    private final ProductService productService;
    private final SettingsService settingsService;

    /**
     * Creates and saves a new order item based on the provided `OrderItemSaveRequest`.
     *
     * @param orderItemSaveRequest The request object containing order item data to be saved.
     * @return A response object containing the saved order item's information.
     * @throws RuntimeException if the quantity of the order item is not greater than zero.
     */
    @Transactional
    public OrderItemSaveResponse save(OrderItemSaveRequest orderItemSaveRequest) {
        OrderItem orderItem = buildOrderItemAndSave(orderItemSaveRequest);
        return convertOrderItemToResponse(orderItem);
    }

    /**
     * Retrieves a list of all order items currently stored in the system.
     *
     * @return A list of all order item records.
     */
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    /**
     * Updates an existing order item's information based on the provided `OrderItemUpdateRequest`.
     *
     * @param orderItemUpdateRequest The request object containing updated order item data.
     * @return A response object containing the updated order item's information.
     * @throws RuntimeException if the specified order item does not exist.
     */
    @Transactional
    public OrderItemSaveResponse update(OrderItemUpdateRequest orderItemUpdateRequest) {
        Optional<OrderItem> orderItemOptional = orderItemRepository.findById(orderItemUpdateRequest.getId());
        if (orderItemOptional.isPresent()) {
            OrderItem orderItem = orderItemOptional.get();
            int newQuantity = orderItemUpdateRequest.getQuantity();
            double newUnitPrice = orderItemUpdateRequest.getUnitPrice();
            double newTotalPrice = newQuantity * newUnitPrice;
            orderItem.setQuantity(newQuantity);
            orderItem.setUnitPrice(newUnitPrice);
            orderItem.setTotalPrice(newTotalPrice);
            OrderItem savedOrderItem = orderItemRepository.save(orderItem);
            return convertOrderItemToResponse(savedOrderItem);
        }
        throw new RuntimeException("OrderItem not found");
    }

    /**
     * Deletes an order item by marking it as inactive and removing it from the database.
     *
     * @param uuid The UUID of the order item to delete.
     * @throws RuntimeException if the specified order item does not exist.
     */
    @Transactional
    public void delete(UUID uuid) {
        OrderItem orderItem = getOrderItemByUUID(uuid);
        if (orderItem != null) {
            orderItemRepository.save(orderItem);
            orderItemRepository.deleteById(orderItem.getId());
        } else {
            throw new RuntimeException("Customer not found");
        }
    }

    /**
     * Retrieves an order item by its UUID.
     *
     * @param uuid The UUID of the order item to retrieve.
     * @return The order item object if found, or null if not found.
     */
    public OrderItem getOrderItemByUUID(UUID uuid) {
        Optional<OrderItem> orderItemOptional = orderItemRepository.findOrderItemByUuid(uuid);
        return orderItemOptional.orElse(null);
    }

    private OrderItemSaveResponse convertOrderItemToResponse(OrderItem orderItem) {
        return OrderItemSaveResponse.builder()
                .id(orderItem.getId())
                .orderId(orderItem.getOrder().getId())
                .productName(orderItem.getProduct().getName())
                .quantity(orderItem.getQuantity())
                .unitPrice(orderItem.getUnitPrice())
                .totalPrice(orderItem.getTotalPrice())
                .build();
    }

    private OrderItem buildOrderItemAndSave(OrderItemSaveRequest orderItemSaveRequest) {
        Order orderByReference = orderService.getReferenceById(orderItemSaveRequest.getOrderId());
        Product productByReference = productService.getReferenceById(orderItemSaveRequest.getProductId());
        double vatValuePercentage = settingsService.getSettingValueByKey("VAT");
        int quantity = orderItemSaveRequest.getQuantity();
        if (quantity > 0) {
            double unitPrice = productByReference.isIncludesVAT() ?
                    productByReference.getPrice() * (1 + vatValuePercentage)
                    : productByReference.getPrice();
            double totalPrice = quantity * unitPrice;
            OrderItem newOrderItem = OrderItem
                    .builder()
                    .order(orderByReference)
                    .product(productByReference)
                    .quantity(quantity)
                    .unitPrice(unitPrice)
                    .totalPrice(totalPrice)
                    .build();
            return orderItemRepository.save(newOrderItem);
        }
        throw new RuntimeException("No stock");
    }

}
