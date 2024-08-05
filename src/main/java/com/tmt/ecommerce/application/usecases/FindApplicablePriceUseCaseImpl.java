package com.tmt.ecommerce.application.usecases;

import com.tmt.ecommerce.domain.models.PriceDto;
import com.tmt.ecommerce.domain.ports.in.FindApplicablePriceUseCase;
import com.tmt.ecommerce.domain.ports.out.PriceRepositoryPort;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindApplicablePriceUseCaseImpl implements FindApplicablePriceUseCase {

  private final PriceRepositoryPort priceRepositoryPort;

  @Override
  public Optional<PriceDto> findApplicablePrice(
      LocalDateTime applicationDate, Long productId, Long brandId) {

    if (applicationDate == null || productId == null || brandId == null) {
      throw new IllegalArgumentException(
          "Application date, product ID, and brand ID must not be null");
    }

    return priceRepositoryPort.findApplicablePrice(applicationDate, productId, brandId);
  }
}
