package com.recap.carrental.core.business.abstracts;

import com.recap.carrental.core.entities.User;

import java.util.List;

public interface UserService {
    String create(User user);
    String update(User user);
    String delete(int id);
    User getById(int id);
    User getByEmail(String email);
    List<User> getAll();
}
