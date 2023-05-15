package com.recap.carrental.core.business.concretes;

import com.recap.carrental.core.business.abstracts.TokenService;
import com.recap.carrental.core.dataAccess.TokenRepository;
import com.recap.carrental.core.entities.Token;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TokenManager implements TokenService {

    private final TokenRepository tokenRepository;

    @Override
    public void create(Token token) {
        this.tokenRepository.save(token);
    }

    @Override
    public void updateAll(List<Token> tokens) {
        this.tokenRepository.saveAll(tokens);
    }

    @Override
    public Token getByToken(String token) {
        return this.tokenRepository.findByToken(token);
    }

    @Override
    public Token getValidTokenByToken(String token) {
        return this.tokenRepository.findByTokenAndExpiredIsFalseAndRevokedIsFalse(token);
    }

    @Override
    public List<Token> getAllValidTokenById(int id) {
        return this.tokenRepository.findAllByUserIdAndExpiredIsFalseAndRevokedIsFalse(id);
    }
}
