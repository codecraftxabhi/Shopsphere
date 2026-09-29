package com.shopsphere.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable=false, updatable=false) private Instant createdAt;
    @Column(nullable=false) private Instant updatedAt;
    @PrePersist void prePersist(){ createdAt=updatedAt=Instant.now(); }
    @PreUpdate void preUpdate(){ updatedAt=Instant.now(); }
    public UUID getId(){return id;} public void setId(UUID id){this.id=id;}
    public Instant getCreatedAt(){return createdAt;} public Instant getUpdatedAt(){return updatedAt;}
}
