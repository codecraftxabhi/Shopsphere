package com.shopsphere.entity;
import jakarta.persistence.*;
@Entity @Table(name="inventory") public class Inventory extends BaseEntity {
 @OneToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="product_id",unique=true) private Product product;
 @Column(nullable=false) private int quantity; @Version private long version;
 public Product getProduct(){return product;} public void setProduct(Product v){product=v;} public int getQuantity(){return quantity;} public void setQuantity(int v){quantity=v;} public long getVersion(){return version;}
}
