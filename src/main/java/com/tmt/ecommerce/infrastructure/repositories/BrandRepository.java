package com.tmt.ecommerce.infrastructure.repositories;

import com.tmt.ecommerce.infrastructure.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {}
