package com.ecommerce.controller;

import com.ecommerce.entity.Cart;
import com.ecommerce.service.CartService;
import com.ecommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping
public class CartController {

    private final CartService cartService;

    private final ProductService productService;

    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }
    @PostMapping("/cart/add/{productId}")
    public ResponseEntity<String> addProductToCart(@PathVariable Long productId, @RequestParam int quantity) {
        cartService.addProductToCart(productId, quantity);
        return ResponseEntity.ok("Product added to cart successfully");
    }

    @PostMapping("/cart/remove/{productId}")
    public ResponseEntity<String> removeProductFromCart(@PathVariable Long productId , @RequestParam int quantity){
        cartService.removeProductFromCart(productId,quantity);
        return ResponseEntity.ok("Product removed from cart successfully");
    }


    @GetMapping("/cart")
    public ResponseEntity<List<Cart>> getCart(){
        List<Cart> cart = cartService.getCart();
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/cart/clear")
    public ResponseEntity<String> clearCart(){
        cartService.clearCart();
        return ResponseEntity.ok("Cart cleared successfully");
    }

}
