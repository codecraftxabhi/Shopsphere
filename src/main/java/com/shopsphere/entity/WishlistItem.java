package com.shopsphere.entity;
import jakarta.persistence.*;
@Entity @Table(name="wishlist_items",uniqueConstraints=@UniqueConstraint(columnNames={"user_id","product_id"})) public class WishlistItem extends BaseEntity { @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="user_id") private User user; @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="product_id") private Product product; public User getUser(){return user;} public void setUser(User v){user=v;} public Product getProduct(){return product;} public void setProduct(Product v){product=v;} }
