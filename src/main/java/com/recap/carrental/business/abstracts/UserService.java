package com.recap.carrental.business.abstracts;

import com.recap.carrental.business.requests.userRequests.UserCreateRequest;
import com.recap.carrental.business.requests.userRequests.UserUpdateRequest;
import com.recap.carrental.business.responses.userResponses.UserGetAllResponse;
import com.recap.carrental.business.responses.userResponses.UserGetByIdResponse;

import java.util.List;

public interface UserService {
    String create(UserCreateRequest request);
    String update(int id, UserUpdateRequest request);
    String delete(int id);
    UserGetByIdResponse getById(int id);
    List<UserGetAllResponse> getAll();
}
