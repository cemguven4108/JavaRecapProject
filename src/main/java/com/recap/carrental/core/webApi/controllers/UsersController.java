package com.recap.carrental.core.webApi.controllers;

import com.recap.carrental.core.business.abstracts.UserService;
import com.recap.carrental.core.entities.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/users")
public class UsersController {

    private final UserService userService;

    @PostMapping(value = "/create")
    public String create(@RequestBody User user) {
        return this.userService.create(user);
    }

    @PutMapping(value = "/update")
    public String update(@RequestBody User user) {
        return this.userService.update(user);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id) {
        return this.userService.delete(id);
    }

    @GetMapping(value = "/getById/{id}")
    public User getById(@PathVariable int id) {
        return this.userService.getById(id);
    }

    @GetMapping(value = "/getAll")
    public List<User> getAll() {
        return this.userService.getAll();
    }
}
