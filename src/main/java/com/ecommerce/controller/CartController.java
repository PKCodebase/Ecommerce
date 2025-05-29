//package com.ecommerce.controller;
//
//import com.ecommerce.entity.Cart;
//import com.ecommerce.service.CartService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Collections;
//import java.util.List;
//
//@RestController
//@RequestMapping
//public class CartController {
//
//    private final CartService cartService;
//
//    public CartController(CartService cartService) {
//        this.cartService = cartService;
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<String> addProductToCart(Long productId, int quantity){
//        cartService.addProductToCart(productId,quantity);
//        return ResponseEntity.ok("Product added to cart successfully");
//    }
//
//    @PostMapping("/remove")
//    public ResponseEntity<String> removeProductFromCart(Long productId, int quantity){
//        cartService.removeProductFromCart(productId, quantity);
//        return ResponseEntity.ok("Product removed from cart successfully");
//    }
//
//    @DeleteMapping("/clear")
//    public ResponseEntity<String> clearCart(){
//        cartService.clearCart();
//        return ResponseEntity.ok("Cart cleared successfully");
//    }
//
//    @GetMapping("/get")
//    public ResponseEntity<List<Cart>> getCart(){
//        Cart cart = (Cart) cartService.getCart();
//        return ResponseEntity.ok(Collections.singletonList(cart));
//    }
//
////   Public ResponseEntity<Cart> getCart(){
////        return ResponseEntity.ok(cartService.getCart());
////    }
//
//
//}
