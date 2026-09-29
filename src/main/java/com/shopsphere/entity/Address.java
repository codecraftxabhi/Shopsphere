package com.shopsphere.entity;
import jakarta.persistence.*;
@Entity @Table(name="addresses") public class Address extends BaseEntity {
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="user_id") private User user;
 @Column(nullable=false) private String line1; private String line2; @Column(nullable=false) private String city; @Column(nullable=false) private String state; @Column(nullable=false) private String postalCode; @Column(nullable=false) private String country;
 public User getUser(){return user;} public void setUser(User v){user=v;} public String getLine1(){return line1;} public void setLine1(String v){line1=v;} public String getLine2(){return line2;} public void setLine2(String v){line2=v;} public String getCity(){return city;} public void setCity(String v){city=v;} public String getState(){return state;} public void setState(String v){state=v;} public String getPostalCode(){return postalCode;} public void setPostalCode(String v){postalCode=v;} public String getCountry(){return country;} public void setCountry(String v){country=v;}
}
