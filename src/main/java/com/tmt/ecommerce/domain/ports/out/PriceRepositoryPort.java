package com.tmt.ecommerce.domain.ports.out;

import com.tmt.ecommerce.domain.models.PriceDto;
import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepositoryPort {

  /**
   * Finds the applicable price based on the application date, product ID, and brand ID.
   *
   * @param applicationDate the date to search for the applicable price
   * @param productId the product identifier
   * @param brandId the brand identifier
   * @return an Optional containing the applicable PriceDto, or empty if no price is found
   */
  Optional<PriceDto> findApplicablePrice(
      LocalDateTime applicationDate, Long productId, Long brandId);
}
