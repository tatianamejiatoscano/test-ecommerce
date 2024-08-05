package com.tmt.ecommerce.domain.ports.in;

import com.tmt.ecommerce.domain.models.PriceDto;
import java.time.LocalDateTime;
import java.util.Optional;

public interface FindApplicablePriceUseCase {

  /**
   * Finds the applicable price for the given product and brand at the specified application date.
   *
   * @param applicationDate The date when the price is applicable
   * @param productId The ID of the product
   * @param brandId The ID of the brand
   * @return {@link Optional<PriceDto>} The applicable price for the given product, if not found
   *     result, returns Optional.empty()
   */
  Optional<PriceDto> findApplicablePrice(
      LocalDateTime applicationDate, Long productId, Long brandId);
}
