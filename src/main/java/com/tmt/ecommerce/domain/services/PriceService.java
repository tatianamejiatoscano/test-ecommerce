package com.tmt.ecommerce.domain.services;

import com.tmt.ecommerce.domain.models.PriceDto;
import com.tmt.ecommerce.domain.ports.in.FindApplicablePriceUseCase;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PriceService {

  private final FindApplicablePriceUseCase findApplicablePriceUseCase;

  /**
   * Finds the applicable price for the given product and brand at the specified application date.
   *
   * @param applicationDate The date when the price is applicable
   * @param productId The ID of the product
   * @param brandId The ID of the brand
   * @return {@link Optional<PriceDto>} The applicable price for the given product, if not found
   *     result, returns Optional.empty()
   */
  public Optional<PriceDto> findApplicablePrice(
      LocalDateTime applicationDate, Long productId, Long brandId) {

    return findApplicablePriceUseCase.findApplicablePrice(applicationDate, productId, brandId);
  }
}
