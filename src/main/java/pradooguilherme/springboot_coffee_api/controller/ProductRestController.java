package pradooguilherme.springboot_coffee_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pradooguilherme.springboot_coffee_api.dto.CreateProductBaseRequest;
import pradooguilherme.springboot_coffee_api.dto.CreateProductRequest;
import pradooguilherme.springboot_coffee_api.model.Product;
import pradooguilherme.springboot_coffee_api.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAllProducts(){
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CreateProductBaseRequest> createProduct(@RequestBody CreateProductBaseRequest request){
        productService.insert(request);
        return ResponseEntity.ok(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){
        productService.update(id, product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.ok().build();
    }

}
