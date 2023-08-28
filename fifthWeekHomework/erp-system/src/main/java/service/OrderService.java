package main.java.service;

import main.java.dto.order.OrderSaveRequest;
import main.java.dto.order.OrderSaveResponse;
import com.aslihanhasar.erpsystem.entity.*;
import main.java.enums.OrderStatus;
import main.java.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final OrderItemService orderItemService;
    private final CustomerService customerService;
    private final SettingsService settingsService;
    private final StockService stockService;

    /**
     * Creates a new order based on the provided `OrderSaveRequest` and associates it with a customer.
     *
     * @param orderSaveRequest The request object containing order and customer information.
     * @return A response object containing the saved order's information.
     */
    public OrderSaveResponse save(OrderSaveRequest orderSaveRequest) {
        Customer customer = customerService.getReferenceById(orderSaveRequest.getCustomerId());

        if (customer != null) {
            for (OrderItem orderItem : orderSaveRequest.getOrderItems()) {
                Stock productStock = stockService.getStockByProductId(orderItem.getProduct().getId());
                int productQuantity = productStock.getQuantity();
                if (productQuantity < orderItem.getQuantity() || orderItem.getQuantity() == 0) {
                    OrderStatus orderStatus = OrderStatus.AWAITING_APPROVAL;
                    orderItem.getOrder().setOrderStatus(orderStatus);
                }
            }
        }
        Order order = Order.builder()
                .customer(customer)
                .orderItems(orderSaveRequest.getOrderItems())
                .build();
        Order savedOrder = orderRepository.save(order);
        return convertOrderToResponse(savedOrder);
    }

    /**
     * Approves an existing order, checks stock availability, generates an invoice, and updates its status.
     *
     * @param orderId The ID of the order to approve.
     * @return A response object containing the updated order's information.
     * @throws RuntimeException if the order is already approved or if there's insufficient stock.
     */
    public OrderSaveResponse approveOrder(Long orderId) {
        Order order = getOrderById(orderId);
        if (order.getOrderStatus() == OrderStatus.APPROVED) {
            throw new RuntimeException("Order is already approved.");
        }
        checkStockAndUpdateOrderStatus(order);
        createInvoice(order);
        order.setOrderStatus(OrderStatus.APPROVED);
        orderRepository.save(order);
        return convertOrderToResponse(order);
    }

    /**
     * Retrieves a reference to an order by its ID without fully loading its data.
     *
     * @param id The ID of the order to retrieve.
     * @return A reference to the order.
     */
    public Order getReferenceById(Long id) {
        return orderRepository.getReferenceById(id);
    }

    private void checkStockAndUpdateOrderStatus(Order order) {
        for (OrderItem orderItem : order.getOrderItems()) {
            Stock productStock = stockService.getStockByProductId(orderItem.getProduct().getId());
            int productQuantity = productStock.getQuantity();
            if (productQuantity < orderItem.getQuantity() || orderItem.getQuantity() == 0) {
                throw new RuntimeException("Not enough stock for product: ");
            }
            productStock.setQuantity(productStock.getQuantity() - orderItem.getQuantity());
        }
    }

    private void createInvoice(Order order) {
        // Fatura oluşturma işlemleri burada yapılacak.
    }

    private Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found."));
    }

    private OrderSaveResponse convertOrderToResponse(Order order) {
        return OrderSaveResponse.builder()
                .id(order.getId())
                .orderStatus(order.getOrderStatus())
                .build();
    }

    private double calculateTotalAmountWithoutVAT(List<OrderItem> orderItems) {
        return orderItems.stream()
                .mapToDouble(orderItem -> orderItem.getQuantity() * orderItem.getProduct().getPrice())
                .sum();
    }

    private double calculateTotalAmountWithVAT(double totalAmountWithoutVAT) {
        double vatValue = settingsService.getSettingValueByKey("KDV");
        return totalAmountWithoutVAT * (1 + (vatValue / 100));
    }
}
