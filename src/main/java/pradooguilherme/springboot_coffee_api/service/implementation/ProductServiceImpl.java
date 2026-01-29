package pradooguilherme.springboot_coffee_api.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pradooguilherme.springboot_coffee_api.dto.CreateBarProductRequest;
import pradooguilherme.springboot_coffee_api.dto.CreateProductBaseRequest;
import pradooguilherme.springboot_coffee_api.dto.CreateProductRequest;
import pradooguilherme.springboot_coffee_api.model.BarProduct;
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
    public void insert(CreateProductBaseRequest request) {
        if(request instanceof CreateProductRequest){
            Product product = new Product();
            product.setName(((CreateProductRequest) request).name());
            product.setPrice(((CreateProductRequest) request).price());
            product.setDescription(((CreateProductRequest) request).description());
            productRepository.save(product);

        } else if (request instanceof CreateBarProductRequest) {
                BarProduct product = new BarProduct();
                product.setName(((CreateBarProductRequest) request).name());
                product.setPrice(((CreateBarProductRequest) request).price());
                product.setDescription(((CreateBarProductRequest) request).description());
                product.setBarProductSize(((CreateBarProductRequest) request).barProductSize());
                product.setFinalPrice(((CreateBarProductRequest) request).finalPrice());
                productRepository.save(product);
            } else {
            throw new IllegalArgumentException("Unsupported product type");
        }
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
