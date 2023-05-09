package com.recap.carrental.dataAccess;

import com.recap.carrental.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {
    boolean existsByCarIdAndReturnDateIsNull(int carId);
}
