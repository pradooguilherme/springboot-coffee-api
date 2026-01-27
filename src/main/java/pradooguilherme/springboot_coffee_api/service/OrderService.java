package pradooguilherme.springboot_coffee_api.service;

import pradooguilherme.springboot_coffee_api.model.Order;

public interface OrderService {
    Iterable<Order> findAll();
    Order findById(Long id);
    void insert(Order order);
    void update(Long id, Order order);
    void delete(Long id);
}
