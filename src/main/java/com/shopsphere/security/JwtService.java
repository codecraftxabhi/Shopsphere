package com.shopsphere.security;
import io.jsonwebtoken.*; import io.jsonwebtoken.security.Keys; import org.springframework.beans.factory.annotation.Value; import org.springframework.stereotype.Service; import java.nio.charset.StandardCharsets; import java.security.Key; import java.time.Instant; import java.util.*;
@Service public class JwtService {
 private final Key key; private final long expirationSeconds;
 public JwtService(@Value("${app.jwt.secret}") String secret,@Value("${app.jwt.expiration-seconds}") long expirationSeconds){ if(secret.length()<32) throw new IllegalArgumentException("JWT secret must be at least 32 characters"); key=Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)); this.expirationSeconds=expirationSeconds; }
 public String generate(UUID userId,String email,String role){ Instant now=Instant.now(); return Jwts.builder().subject(userId.toString()).claim("email",email).claim("role",role).issuedAt(Date.from(now)).expiration(Date.from(now.plusSeconds(expirationSeconds))).signWith(key).compact(); }
 public Claims parse(String token){return Jwts.parser().verifyWith((javax.crypto.SecretKey)key).build().parseSignedClaims(token).getPayload();}
 public long expirationSeconds(){return expirationSeconds;}
}
