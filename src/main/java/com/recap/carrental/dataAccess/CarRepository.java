package com.recap.carrental.dataAccess;

import com.recap.carrental.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    boolean existsByPlateNumber(String plateNumber);
    List<Car> findAllByModel_Id(int modelId);
    List<Car> findAllByColor_Id(int colorId);
}
