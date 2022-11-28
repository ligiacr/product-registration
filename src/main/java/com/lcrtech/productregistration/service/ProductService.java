package com.lcrtech.productregistration.service;

import com.lcrtech.productregistration.model.Product;
import com.lcrtech.productregistration.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    private Product product;

    public Product saveProduct(Product product) {

        return productRepository.save(product);
    }

    public List<Product> listProducts() {

        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);

        return productOptional.get();
    }

    public Product updateProduct(Product product) {
        // Busca a linha do objeto e devolve //
        if(product.getId() != null) {
            Product old = this.findProductById(product.getId());
            product.setId(old.getId());
        }
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        Product product = this.findProductById(id);

        productRepository.delete(product);
    }
}
