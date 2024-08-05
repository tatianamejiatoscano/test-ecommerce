package com.tmt.ecommerce.domain.models;

import io.swagger.v3.oas.annotations.media.Schema;

/** Enum representing supported currencies. */
@Schema(description = "Supported currencies")
public enum CurrencyEnum {
  @Schema(description = "Euro", example = "EUR")
  EUR,

  @Schema(description = "United States Dollar", example = "USD")
  USD
}
