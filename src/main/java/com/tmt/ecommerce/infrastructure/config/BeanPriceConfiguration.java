package com.tmt.ecommerce.infrastructure.config;

import com.tmt.ecommerce.domain.services.PriceService;
import com.tmt.ecommerce.application.usecases.FindApplicablePriceUseCaseImpl;
import com.tmt.ecommerce.domain.ports.in.FindApplicablePriceUseCase;
import com.tmt.ecommerce.domain.ports.out.PriceRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanPriceConfiguration {

  /**
   * Creates a new PriceService instance.
   *
   * @param findApplicablePriceUseCase The use case to find the applicable price
   * @return {@link PriceService} The price service
   */
  @Bean
  public PriceService priceService(FindApplicablePriceUseCase findApplicablePriceUseCase) {
    return new PriceService(findApplicablePriceUseCase);
  }

  /**
   * Creates a new FindApplicablePriceUseCase instance.
   *
   * @param priceRepositoryPort The price repository port
   * @return {@link FindApplicablePriceUseCase} The use case to find the applicable price
   */
  @Bean
  public FindApplicablePriceUseCase findApplicablePriceUseCase(
      PriceRepositoryPort priceRepositoryPort) {
    return new FindApplicablePriceUseCaseImpl(priceRepositoryPort);
  }
}
