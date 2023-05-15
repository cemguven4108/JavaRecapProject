package com.recap.carrental.core.business.abstracts;

import com.recap.carrental.core.entities.Token;

import java.util.List;

public interface TokenService {
    void create(Token token);
    void updateAll(List<Token> tokens);
    Token getByToken(String token);
    Token getValidTokenByToken(String token);
    List<Token> getAllValidTokenById(int id);
}
