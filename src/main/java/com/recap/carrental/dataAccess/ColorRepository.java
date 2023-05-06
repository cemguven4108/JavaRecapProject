package com.recap.carrental.dataAccess;

import com.recap.carrental.entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, Integer> {
    boolean existsByColorName(String colorName);
}
