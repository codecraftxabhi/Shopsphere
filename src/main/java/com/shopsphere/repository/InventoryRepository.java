package com.shopsphere.repository;
import com.shopsphere.entity.Inventory; import java.util.*; import org.springframework.data.jpa.repository.*; import jakarta.persistence.LockModeType;
public interface InventoryRepository extends JpaRepository<Inventory,UUID>{
 @Lock(LockModeType.PESSIMISTIC_WRITE) @Query("select i from Inventory i where i.product.id=:productId") Optional<Inventory> findForUpdate(@Param("productId") UUID productId);
 Optional<Inventory> findByProductId(UUID productId);
}
