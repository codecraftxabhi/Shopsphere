package com.shopsphere.entity;
import jakarta.persistence.*; import java.util.*;
@Entity @Table(name="users")
public class User extends BaseEntity {
 @Column(nullable=false) private String name;
 @Column(nullable=false,unique=true) private String email;
 @Column(nullable=false) private String passwordHash;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private Role role=Role.CUSTOMER;
 @Column(nullable=false) private boolean enabled=true;
 public String getName(){return name;} public void setName(String v){name=v;} public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getPasswordHash(){return passwordHash;} public void setPasswordHash(String v){passwordHash=v;} public Role getRole(){return role;} public void setRole(Role v){role=v;} public boolean isEnabled(){return enabled;} public void setEnabled(boolean v){enabled=v;}
}
