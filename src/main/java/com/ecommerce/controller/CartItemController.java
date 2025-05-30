package com.ecommerce.controller;

import com.ecommerce.entity.CartItem;
import com.ecommerce.service.CartItemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart-items")
@Tag(name = "Cart Item", description = "Endpoints for managing cart items")
public class CartItemController {

    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItem> getCartItem(@PathVariable Long id){
        CartItem cartItem = cartItemService.getCartItemById(id);
        return ResponseEntity.ok(cartItem);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CartItem>> getAllCartItems(){
        List<CartItem> cartItems = cartItemService.getAllCartItems();
        return ResponseEntity.ok(cartItems);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCartItem(@PathVariable Long id){
        cartItemService.deleteCartItem(id);
        return ResponseEntity.ok("Cart item deleted successfully");
    }

    @PutMapping("/{id}/quantity")
    public ResponseEntity<CartItem> updateCartItemQuantity(@PathVariable Long id,@RequestParam int quantity){
        cartItemService.updateCartItemQuantity(id,quantity);
        CartItem updatedCartItem=cartItemService.getCartItemById(id);
        return ResponseEntity.ok(updatedCartItem);
    }

}
