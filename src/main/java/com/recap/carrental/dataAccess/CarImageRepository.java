package com.recap.carrental.dataAccess;

import com.recap.carrental.entities.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarImageRepository extends JpaRepository<CarImage, Integer> {

    boolean existsByCarId(int carId);
}
