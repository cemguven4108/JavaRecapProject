package com.recap.carrental.dataAccess;

import com.recap.carrental.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
    boolean existsByModelName(String modelName);
    List<Model> findAllByBrand_Id(int brandId);
}
