package com.recap.carrental.dataAccess;

import com.recap.carrental.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsByCompanyName(String companyName);
}
