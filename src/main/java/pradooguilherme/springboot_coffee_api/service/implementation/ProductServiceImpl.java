package pradooguilherme.springboot_coffee_api.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pradooguilherme.springboot_coffee_api.model.Product;
import pradooguilherme.springboot_coffee_api.model.ProductRepository;
import pradooguilherme.springboot_coffee_api.service.ProductService;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public void insert(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Long id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            productRepository.save(product);
        }
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
