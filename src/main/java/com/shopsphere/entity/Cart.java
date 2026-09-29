package com.shopsphere.entity;
import jakarta.persistence.*; import java.util.*;
@Entity @Table(name="carts") public class Cart extends BaseEntity { @OneToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="user_id",unique=true) private User user; public User getUser(){return user;} public void setUser(User v){user=v;} }
