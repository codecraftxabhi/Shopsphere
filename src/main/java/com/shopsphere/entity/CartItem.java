package com.shopsphere.entity;
import jakarta.persistence.*; import java.math.BigDecimal;
@Entity @Table(name="cart_items",uniqueConstraints=@UniqueConstraint(columnNames={"cart_id","product_id"})) public class CartItem extends BaseEntity {
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="cart_id") private Cart cart; @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="product_id") private Product product; @Column(nullable=false) private int quantity;
 public Cart getCart(){return cart;} public void setCart(Cart v){cart=v;} public Product getProduct(){return product;} public void setProduct(Product v){product=v;} public int getQuantity(){return quantity;} public void setQuantity(int v){quantity=v;}
}
