package com.recap.carrental.core.business.abstracts;

import com.recap.carrental.core.business.requests.userRequests.UserCreateRequest;
import com.recap.carrental.core.business.requests.userRequests.UserUpdateRequest;
import com.recap.carrental.core.business.responses.userResponses.UserGetAllResponse;
import com.recap.carrental.core.business.responses.userResponses.UserGetByEmailResponse;
import com.recap.carrental.core.business.responses.userResponses.UserGetByIdResponse;

import java.util.List;

public interface UserService {
    String create(UserCreateRequest request);
    String update(int id, UserUpdateRequest request);
    String delete(int id);
    UserGetByIdResponse getById(int id);
    UserGetByEmailResponse getByEmail(String email);
    List<UserGetAllResponse> getAll();
}
