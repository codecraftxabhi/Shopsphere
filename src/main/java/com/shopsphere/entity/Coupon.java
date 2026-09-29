package com.shopsphere.entity;
import jakarta.persistence.*; import java.math.BigDecimal; import java.time.*;
@Entity @Table(name="coupons") public class Coupon extends BaseEntity { @Column(nullable=false,unique=true) private String code; @Column(nullable=false,precision=5,scale=2) private BigDecimal discountPercent; private Instant expiresAt; @Column(nullable=false) private boolean active=true;
 public String getCode(){return code;} public void setCode(String v){code=v;} public BigDecimal getDiscountPercent(){return discountPercent;} public void setDiscountPercent(BigDecimal v){discountPercent=v;} public Instant getExpiresAt(){return expiresAt;} public void setExpiresAt(Instant v){expiresAt=v;} public boolean isActive(){return active;} public void setActive(boolean v){active=v;}}
