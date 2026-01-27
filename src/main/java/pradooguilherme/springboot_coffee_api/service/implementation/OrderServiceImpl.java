package pradooguilherme.springboot_coffee_api.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pradooguilherme.springboot_coffee_api.model.Order;
import pradooguilherme.springboot_coffee_api.model.OrderRepository;
import pradooguilherme.springboot_coffee_api.service.OrderService;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElse(null);
    }

    @Override
    public void insert(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void update(Long id, Order order) {
        Optional<Order> orderOptional = orderRepository.findById(id);

        if(orderOptional.isPresent()) {
            orderRepository.save(order);
        }
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
