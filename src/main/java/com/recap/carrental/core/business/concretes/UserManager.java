package com.recap.carrental.core.business.concretes;

import com.recap.carrental.core.business.abstracts.UserService;
import com.recap.carrental.core.dataAccess.UserRepository;
import com.recap.carrental.core.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;

    @Override
    public void create(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void update(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public User getById(int id) {
        return this.userRepository.findById(id).orElseThrow();
    }

    @Override
    public User getByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }
}
