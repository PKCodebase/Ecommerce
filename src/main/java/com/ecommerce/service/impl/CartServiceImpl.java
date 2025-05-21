package com.ecommerce.service.impl;

import com.ecommerce.entity.Cart;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    private final ProductRepository productRepository;

    public CartServiceImpl(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }


    @Override
    public void addProductToCart(Long productId, int quantity) {

        Product product = productRepository.findById(productId)
                .orElseThrow(()->new ResourceNotFoundException("Product not available"));

        if (product.getQuantity() < quantity) {
            throw new RuntimeException("Insufficient stock");
        }
        Cart cart = cartRepository.findById(productId)
                .orElseGet(Cart::new);

        cart.addProduct(product, quantity);
        cartRepository.save(cart);
    }

    @Override
    public void removeProductFromCart(Long productId, int quantity) {
        Cart cart = cartRepository.findById(productId)
                .orElseThrow(()->new ResourceNotFoundException("Product not available in cart"));

        if (cart.getQuantity() < quantity) {
            throw new RuntimeException("Insufficient quantity in cart");
        }

        cart.removeProduct(productId, quantity);
        if (cart.getQuantity() == 0) {
            cartRepository.delete(cart);
        } else {
            cartRepository.save(cart);
        }
    }

    @Override
    public void clearCart() {
        cartRepository.deleteAll();

    }

    @Override
    public List<Cart> getCart() {
        return cartRepository.findAll();
    }
}
