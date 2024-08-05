package com.tmt.ecommerce.domain.models;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;

/** Represents a price data transfer object. */
@Getter
@Setter
@Builder
public class PriceDto {

  @Schema(
      name = "productId",
      description = "Identifier for product",
      requiredMode = Schema.RequiredMode.REQUIRED,
      example = "123")
  private Long productId;

  @Schema(
      name = "brandId",
      description = "Identifier for brand",
      requiredMode = Schema.RequiredMode.REQUIRED,
      example = "1")
  private Long brandId;

  @Schema(
      name = "startDate",
      description = "Start date for applicable to price.",
      requiredMode = Schema.RequiredMode.REQUIRED,
      example = "2020-06-14-00.00.00")
  private LocalDateTime startDate;

  @Schema(
      name = "endDate",
      description = "End date for applicable to price",
      requiredMode = Schema.RequiredMode.REQUIRED,
      example = "2020-12-31-23.59.59")
  private LocalDateTime endDate;

  @Schema(
      name = "priceList",
      description = "Identifier of the applicable price list",
      requiredMode = Schema.RequiredMode.REQUIRED,
      example = "123")
  private Long priceList;

  @Schema(
      name = "price",
      description = "Final sale price",
      requiredMode = Schema.RequiredMode.REQUIRED,
      example = "35.50")
  private BigDecimal price;

  @Schema(
      name = "currency",
      description = "ISO currency",
      requiredMode = Schema.RequiredMode.REQUIRED,
      example = "EUR")
  private CurrencyEnum currency;
}
