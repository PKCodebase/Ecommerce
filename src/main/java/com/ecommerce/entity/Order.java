//package com.ecommerce.entity;
//
//import jakarta.persistence.*;
//
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//
//@Entity
//@Table(name = "orders")
//public class Order {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long orderId;
//
//    private LocalDateTime orderDate;
//
//    private Double totalAmount;
//
//    private String orderStatus;
//
//    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL , orphanRemoval = true)
//    private List<OrderItem> orderItems;
//
//    private String shippingAddress;
//
//    private String customerName;
//    private String customerEmail;
//
//    private String customerPhone;
//
//    public Long getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(Long orderId) {
//        this.orderId = orderId;
//    }
//
//    public LocalDateTime getOrderDate() {
//        return orderDate;
//    }
//
//    public void setOrderDate(LocalDateTime orderDate) {
//        this.orderDate = orderDate;
//    }
//
//    public Double getTotalAmount() {
//        return totalAmount;
//    }
//
//    public void setTotalAmount(Double totalAmount) {
//        this.totalAmount = totalAmount;
//    }
//
//    public String getOrderStatus() {
//        return orderStatus;
//    }
//
//    public void setOrderStatus(String orderStatus) {
//        this.orderStatus = orderStatus;
//    }
//
//    public List<OrderItem> getOrderItems() {
//        return orderItems;
//    }
//
//    public void setOrderItems(List<OrderItem> orderItems) {
//        this.orderItems = orderItems;
//    }
//
//    public String getShippingAddress() {
//        return shippingAddress;
//    }
//
//    public void setShippingAddress(String shippingAddress) {
//        this.shippingAddress = shippingAddress;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//
//    public String getCustomerEmail() {
//        return customerEmail;
//    }
//
//    public void setCustomerEmail(String customerEmail) {
//        this.customerEmail = customerEmail;
//    }
//
//    public String getCustomerPhone() {
//        return customerPhone;
//    }
//
//    public void setCustomerPhone(String customerPhone) {
//        this.customerPhone = customerPhone;
//    }
//}
