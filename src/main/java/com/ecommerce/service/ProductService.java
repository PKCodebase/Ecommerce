package com.ecommerce.service;

import com.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {


    Product add(Product product);

    List<Product> getAll();

    Product getByName (String name);

    Product update(Product product,Long productId);

    void delete(Long productId);

    void deleteByName(String name);
}
