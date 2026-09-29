package com.shopsphere.entity;
import jakarta.persistence.*; import java.math.BigDecimal; import java.util.*;
@Entity @Table(name="orders",indexes=@Index(name="idx_order_user",columnList="user_id")) public class Order extends BaseEntity {
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="user_id") private User user; @Enumerated(EnumType.STRING) @Column(nullable=false) private OrderStatus status=OrderStatus.PENDING;
 @Column(nullable=false,precision=12,scale=2) private BigDecimal subtotal; @Column(nullable=false,precision=12,scale=2) private BigDecimal discount=BigDecimal.ZERO; @Column(nullable=false,precision=12,scale=2) private BigDecimal total;
 @Column(nullable=false) private String shippingAddressSnapshot;
 public User getUser(){return user;} public void setUser(User v){user=v;} public OrderStatus getStatus(){return status;} public void setStatus(OrderStatus v){status=v;} public BigDecimal getSubtotal(){return subtotal;} public void setSubtotal(BigDecimal v){subtotal=v;} public BigDecimal getDiscount(){return discount;} public void setDiscount(BigDecimal v){discount=v;} public BigDecimal getTotal(){return total;} public void setTotal(BigDecimal v){total=v;} public String getShippingAddressSnapshot(){return shippingAddressSnapshot;} public void setShippingAddressSnapshot(String v){shippingAddressSnapshot=v;}
}
