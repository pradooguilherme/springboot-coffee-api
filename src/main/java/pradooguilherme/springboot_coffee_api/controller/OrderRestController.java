package pradooguilherme.springboot_coffee_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pradooguilherme.springboot_coffee_api.model.Order;
import pradooguilherme.springboot_coffee_api.service.OrderService;

@RestController
@RequestMapping("orders")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<Iterable<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        orderService.insert(order);
        return ResponseEntity.ok(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id,@RequestBody Order order) {
        orderService.update(id, order);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.ok().build();
    }

}
