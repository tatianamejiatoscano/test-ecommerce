package com.tmt.ecommerce.infrastructure.adapters;

import com.tmt.ecommerce.domain.models.PriceDto;
import com.tmt.ecommerce.domain.ports.out.PriceRepositoryPort;
import com.tmt.ecommerce.infrastructure.mappers.PriceMapper;
import com.tmt.ecommerce.infrastructure.repositories.PriceRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PriceRepositoryAdapter implements PriceRepositoryPort {

  private final PriceRepository priceRepository;
  private final PriceMapper priceMapper;

  public Optional<PriceDto> findApplicablePrice(
      LocalDateTime applicationDate, Long productId, Long brandId) {

    if (applicationDate == null || productId == null || brandId == null) {
      throw new IllegalArgumentException(
          "Application date, product ID, and brand ID must not be null");
    }

    return priceRepository
        .findApplicablePrice(applicationDate, productId, brandId)
        .map(priceMapper::toPriceDto);
  }
}
