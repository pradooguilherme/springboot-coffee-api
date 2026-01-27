package pradooguilherme.springboot_coffee_api.service;

import pradooguilherme.springboot_coffee_api.model.Product;

public interface ProductService {
    Iterable<Product> findAll();
    Product findById(Long id);
    void insert(Product product);
    void update(Long id, Product product);
    void delete(Long id);
}
