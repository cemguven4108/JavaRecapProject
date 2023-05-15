package com.recap.carrental.core.dataAccess;

import com.recap.carrental.core.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

    Token findByToken(String token);
    Token findByTokenAndExpiredIsFalseAndRevokedIsFalse(String token);
    List<Token> findAllByUserIdAndExpiredIsFalseAndRevokedIsFalse(int userId);
}
