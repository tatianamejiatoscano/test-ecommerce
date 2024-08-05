package com.tmt.ecommerce.infrastructure.repositories;

import com.tmt.ecommerce.infrastructure.entities.PriceEntity;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

  /**
   * Finds the applicable price for a given product, brand, and application date.
   *
   * @param applicationDate the date to check for applicable price
   * @param productId the ID of the product
   * @param brandId the ID of the brand
   * @return an Optional containing the applicable PriceEntity if found
   */
  @Query(
      "SELECT p FROM PriceEntity p WHERE p.product.id = :productId AND p.brand.id = :brandId "
          + "AND :applicationDate BETWEEN p.startDate AND p.endDate "
          + "ORDER BY p.priority DESC LIMIT 1 ")
  Optional<PriceEntity> findApplicablePrice(
      @Param("applicationDate") LocalDateTime applicationDate,
      @Param("productId") Long productId,
      @Param("brandId") Long brandId);
}
