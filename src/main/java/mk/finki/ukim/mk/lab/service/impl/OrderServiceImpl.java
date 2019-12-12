package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.repository.OrderRepository;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private static AtomicLong longId;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.longId = new AtomicLong(1);
    }

    @Override
    public Order placeOrder(String pizzaType, String pizzaSize, String clientName, String address) {
        Order order = new Order();
        order.setPizzaType(pizzaType);
        order.setPizzaSize(pizzaSize);
        order.setClientName(clientName);
        order.setClientAddress(address);
        order.setOrderId(longId.getAndIncrement());
        return order;
    }
}
