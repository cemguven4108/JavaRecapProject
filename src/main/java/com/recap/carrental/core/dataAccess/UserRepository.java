package com.recap.carrental.core.dataAccess;

import com.recap.carrental.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByEmail(String email);
    boolean existsByEmail(String email);
}
