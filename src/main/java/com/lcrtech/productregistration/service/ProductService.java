package com.lcrtech.productregistration.service;

import com.lcrtech.productregistration.exception.ItemsNotFoundException;
import com.lcrtech.productregistration.model.Item;
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

    public List<Product> findProductByAnyData(String data) {

        return productRepository.findProductByAnyData(data);
    }

    public Product updateProduct(Product product) {

        if(product.getId() != null) {
            Product old = this.findProductById(product.getId());
            product.setId(old.getId());
        }
        return productRepository.save(product);
    }

    public void updateQuantity(Item item) {
        Product product = this.findProductById(item.getProductId());

        if(item.getQuantity() > product.getQuantity()) {
            throw new ItemsNotFoundException();
        }

        product.setQuantity(product.getQuantity() - item.getQuantity());
        this.saveProduct(product);
    }

    public void deleteProduct(Long id) {
        Product product = this.findProductById(id);

        productRepository.delete(product);
    }
}
