package com.ecommerce.service;

import com.ecommerce.entity.CartItem;

import java.util.List;

public interface CartItemService {
    CartItem getCartItemById(Long id);

    List<CartItem> getAllCartItems();

    void deleteCartItem(Long id);

    void updateCartItemQuantity(Long id, int quantity);

}
