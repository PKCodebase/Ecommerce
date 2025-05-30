package com.ecommerce.service.impl;

import com.ecommerce.entity.Cart;
import com.ecommerce.entity.CartItem;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.CartItemRepository;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.CartService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;

    public CartServiceImpl(CartRepository cartRepository,
                           ProductRepository productRepository,
                           CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public void addProductToCart(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        Cart cart = cartRepository.findAll().stream().findFirst().orElseGet(() -> {
            Cart newCart = new Cart();
            return cartRepository.save(newCart);
        });

        CartItem existingItem = cart.getCartItems()
                .stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .orElse(null);

        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
            existingItem.setTotalPrice(existingItem.getQuantity() * product.getPrice());
        } else {
            CartItem newItem = new CartItem(product, quantity);
            newItem.setCart(cart);
            cart.getCartItems().add(newItem);
        }

        updateCartTotal(cart);
        cartRepository.save(cart);
    }

    @Override
    public void removeProductFromCart(Long productId, int quantity) {
        Cart cart = cartRepository.findAll()
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));

        CartItem existingItem = cart.getCartItems()
                .stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Product not in cart"));

        if (existingItem.getQuantity() > quantity) {
            existingItem.setQuantity(existingItem.getQuantity() - quantity);
            existingItem.setTotalPrice(existingItem.getQuantity() * existingItem.getProduct().getPrice());
        } else {
            cart.getCartItems().remove(existingItem);
            cartItemRepository.delete(existingItem);
        }

        updateCartTotal(cart);
        cartRepository.save(cart);
    }

    @Override
    public void clearCart() {
        Cart cart = cartRepository.findAll()
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));

        cart.getCartItems().clear();
        cart.setTotalPrice(0.0);
        cartRepository.save(cart);
    }

    @Override
    public Cart getCart() {
        return cartRepository.findAll().stream()
                .findFirst()
                .orElseGet(() -> cartRepository.save(new Cart()));
    }

    private void updateCartTotal(Cart cart) {
        double total = cart.getCartItems().stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
        cart.setTotalPrice(total);
    }
}
