package com.recap.carrental.dataAccess;

import com.recap.carrental.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

    boolean existsByBrandName(String brandName);
    Brand findByBrandName(String brandName);
}
