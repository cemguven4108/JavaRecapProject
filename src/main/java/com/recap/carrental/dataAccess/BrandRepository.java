package com.recap.carrental.dataAccess;

import com.recap.carrental.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

    boolean existsByBrandName(String brandName);
}
