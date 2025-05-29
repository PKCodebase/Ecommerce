package com.ecommerce.service.impl;

import com.ecommerce.entity.Product;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getByName(String name) {
        return productRepository.findByNameIgnoreCase(name)
                .orElseThrow(()->  new ResourceNotFoundException("Product not available"));
    }

    @Override
    public Product update(Long productId, Product product) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found"));
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setQuantity(product.getQuantity());
        return productRepository.save(existingProduct);
    }
    @Override
    public void delete(Long productId) {
     Product existingProduct = productRepository.findById(productId)
             .orElseThrow(()->new ResourceNotFoundException("Product not available"));
        productRepository.delete(existingProduct);
    }


}
