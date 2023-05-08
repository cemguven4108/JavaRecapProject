package com.recap.carrental.webApi.controllers;

import com.recap.carrental.business.abstracts.UserService;
import com.recap.carrental.business.requests.userRequests.UserCreateRequest;
import com.recap.carrental.business.requests.userRequests.UserUpdateRequest;
import com.recap.carrental.business.responses.userResponses.UserGetAllResponse;
import com.recap.carrental.business.responses.userResponses.UserGetByIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/users")
public class UsersController {

    private final UserService userService;

    @PostMapping(value = "/create")
    public String create(@RequestBody UserCreateRequest request) {
        return this.userService.create(request);
    }

    @PutMapping(value = "/update/{id}")
    public String update(@PathVariable int id, @RequestBody UserUpdateRequest request) {
        return this.userService.update(id, request);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id) {
        return this.userService.delete(id);
    }

    @GetMapping(value = "/getById/{id}")
    public UserGetByIdResponse getById(@PathVariable int id) {
        return this.userService.getById(id);
    }

    @GetMapping(value = "/getAll")
    public List<UserGetAllResponse> getAll() {
        return this.userService.getAll();
    }
}
