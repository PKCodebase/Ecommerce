package com.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    private Integer quantity;

    private Double price;

    private Double totalPrice;

    @JsonIgnore
    @ManyToMany
    private Set<Product> products = new HashSet<>();

    public Cart() {
    }

    public Cart(Long id, Long productId, Integer quantity, Double price, Double totalPrice, Set<Product> products) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product, int quantity) {
        this.products.add(product);
        this.quantity = quantity;
        this.price = product.getPrice();
        this.totalPrice = product.getPrice() * quantity;
    }

    public void removeProduct(Long productId, int quantity) {
        Product productToRemove = null;
        for (Product product : this.products) {
            if (product.getId().equals(productId)) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null) {
            this.products.remove(productToRemove);
            this.quantity -= quantity;
            this.totalPrice -= productToRemove.getPrice() * quantity;
        }
    }
}
