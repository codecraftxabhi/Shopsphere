package com.shopsphere.entity;
import jakarta.persistence.*;
@Entity @Table(name="categories") public class Category extends BaseEntity {
 @Column(nullable=false,unique=true) private String name; @Column(unique=true) private String slug; private String description;
 public String getName(){return name;} public void setName(String v){name=v;} public String getSlug(){return slug;} public void setSlug(String v){slug=v;} public String getDescription(){return description;} public void setDescription(String v){description=v;}
}
