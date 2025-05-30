package com.ecommerce.controller;

import com.ecommerce.entity.Cart;
import com.ecommerce.service.CartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/cart")
@Tag(name = "Cart", description = "Cart management APIs")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add/{productId}")
    public ResponseEntity<String> addProductToCart(@PathVariable Long productId,
                                                   @RequestParam int quantity) {
        cartService.addProductToCart(productId, quantity);
        return ResponseEntity.ok("Product added to cart successfully");
    }

    @PostMapping("/remove/{productId}")
    public ResponseEntity<String> removeProductFromCart(@PathVariable Long productId,
                                                        @RequestParam int quantity) {
        cartService.removeProductFromCart(productId, quantity);
        return ResponseEntity.ok("Product removed from cart successfully");
    }

    @PostMapping("/clear")
    public ResponseEntity<String> clearCart() {
        cartService.clearCart();
        return ResponseEntity.ok("Cart cleared successfully");
    }

    @GetMapping
    public ResponseEntity<Cart> getCart() {
        return ResponseEntity.ok(cartService.getCart());
    }
}
