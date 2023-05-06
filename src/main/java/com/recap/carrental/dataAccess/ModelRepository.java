package com.recap.carrental.dataAccess;

import com.recap.carrental.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
    boolean existsByModelName(String modelName);
}
