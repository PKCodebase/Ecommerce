package com.ecommerce.service;

import com.ecommerce.entity.Cart;

import java.util.List;

public interface CartService {

    void addProductToCart(Long productId, int quantity);

    void removeProductFromCart(Long productId, int quantity);

    void clearCart();

    List<Cart> getCart();

}
