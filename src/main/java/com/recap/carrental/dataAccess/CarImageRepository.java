package com.recap.carrental.dataAccess;

import com.recap.carrental.entities.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarImageRepository extends JpaRepository<CarImage, Integer> {

    boolean existsByCarId(int carId);
    List<CarImage> findAllByCarId(int carId);
}
