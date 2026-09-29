package com.shopsphere.entity;
import jakarta.persistence.*; import java.math.BigDecimal;
@Entity @Table(name="products",indexes={@Index(name="idx_product_slug",columnList="slug"),@Index(name="idx_product_category",columnList="category_id")})
public class Product extends BaseEntity {
 @Column(nullable=false) private String name; @Column(nullable=false,unique=true) private String slug; @Column(columnDefinition="text") private String description;
 @Column(nullable=false,precision=12,scale=2) private BigDecimal price; @Column(nullable=false) private boolean active=true;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="category_id") private Category category;
 public String getName(){return name;} public void setName(String v){name=v;} public String getSlug(){return slug;} public void setSlug(String v){slug=v;} public String getDescription(){return description;} public void setDescription(String v){description=v;} public BigDecimal getPrice(){return price;} public void setPrice(BigDecimal v){price=v;} public boolean isActive(){return active;} public void setActive(boolean v){active=v;} public Category getCategory(){return category;} public void setCategory(Category v){category=v;}
}
