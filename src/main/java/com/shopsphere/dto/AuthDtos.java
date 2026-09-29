package com.shopsphere.dto;
import jakarta.validation.constraints.*; import java.io.Serializable; import java.math.BigDecimal; import java.time.Instant; import java.util.*;
public final class AuthDtos { private AuthDtos(){}
 public record RegisterRequest(@NotBlank String name,@Email @NotBlank String email,@Size(min=8,max=100) String password){}
 public record LoginRequest(@Email @NotBlank String email,@NotBlank String password){}
 public record TokenResponse(String accessToken,String tokenType,long expiresIn){}
 public record UserResponse(UUID id,String name,String email,String role){}
 public record ProductRequest(@NotBlank String name,@NotBlank String slug,String description,@NotNull @Positive BigDecimal price,@NotNull UUID categoryId,int stock){}
 public record ProductResponse(UUID id,String name,String slug,String description,BigDecimal price,boolean active,UUID categoryId,String categoryName,int stock) implements Serializable {}
 public record CategoryRequest(@NotBlank String name,@NotBlank String slug,String description){}
 public record CategoryResponse(UUID id,String name,String slug,String description){}
 public record CartItemRequest(@NotNull UUID productId,@Min(1) int quantity){}
 public record CartItemResponse(UUID productId,String productName,BigDecimal unitPrice,int quantity,BigDecimal lineTotal){}
 public record CartResponse(UUID cartId,List<CartItemResponse> items,BigDecimal total){}
 public record AddressRequest(@NotBlank String line1,String line2,@NotBlank String city,@NotBlank String state,@NotBlank String postalCode,@NotBlank String country){}
 public record AddressResponse(UUID id,String line1,String line2,String city,String state,String postalCode,String country){}
 public record CreateOrderRequest(@NotNull UUID addressId,String couponCode){}
 public record OrderItemResponse(UUID productId,String productName,int quantity,BigDecimal unitPrice){}
 public record OrderResponse(UUID id,String status,BigDecimal subtotal,BigDecimal discount,BigDecimal total,String shippingAddress,List<OrderItemResponse> items,Instant createdAt){}
 public record PaymentResponse(UUID id,String reference,String status,BigDecimal amount){}
 public record ReviewRequest(@Min(1) @Max(5) int rating,String comment){}
 public record ReviewResponse(UUID id,String userName,int rating,String comment,Instant createdAt){}
 public record CouponRequest(@NotBlank String code,@NotNull @DecimalMin("0.01") @DecimalMax("100") BigDecimal discountPercent,Instant expiresAt){}
}
