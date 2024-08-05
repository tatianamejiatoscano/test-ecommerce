package com.tmt.ecommerce.infrastructure.mappers;

import com.tmt.ecommerce.domain.models.PriceDto;
import com.tmt.ecommerce.infrastructure.entities.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/** Mapper interface for converting between PriceEntity and PriceDto. */
@Mapper(componentModel = "spring")
public interface PriceMapper {

  /**
   * Converts a PriceEntity to a PriceDto.
   *
   * @param priceEntity the entity to convert
   * @return the converted DTO
   */
  @Mapping(source = "product.id", target = "productId")
  @Mapping(source = "brand.id", target = "brandId")
  PriceDto toPriceDto(PriceEntity priceEntity);
}
