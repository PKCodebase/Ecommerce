package com.ecommerce.service.impl;

import com.ecommerce.entity.CartItem;
import com.ecommerce.repository.CartItemRepository;
import com.ecommerce.service.CartItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;

    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CartItem getCartItemById(Long id) {
        return cartItemRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Cart Item not found"+id));
    }

    @Override
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public void deleteCartItem(Long id) {
      CartItem cartItem = getCartItemById(id);
      cartItemRepository.delete(cartItem);
    }

    @Override
    public void updateCartItemQuantity(Long id, int quantity) {
       CartItem cartItem = getCartItemById(id);
       if(quantity <= 0 ){
          throw new RuntimeException("Quantity must be greater than 0");
       }
       cartItem.setQuantity(quantity);
       cartItem.setTotalPrice(cartItem.getProduct().getPrice() * quantity);
       cartItemRepository.save(cartItem);
    }
}
