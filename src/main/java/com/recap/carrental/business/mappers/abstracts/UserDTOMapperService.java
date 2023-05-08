package com.recap.carrental.business.mappers.abstracts;

import com.recap.carrental.business.requests.userRequests.UserCreateRequest;
import com.recap.carrental.business.requests.userRequests.UserUpdateRequest;
import com.recap.carrental.business.responses.userResponses.UserGetAllResponse;
import com.recap.carrental.business.responses.userResponses.UserGetByIdResponse;
import com.recap.carrental.entities.User;

import java.util.List;

public interface UserDTOMapperService {
    User UserCreateRequestToUser(UserCreateRequest request);
    User UserUpdateRequestToUser(int id, UserUpdateRequest request);
    UserGetByIdResponse UserToUserGetByIdResponse(User user);
    List<UserGetAllResponse> UserToUserGetAllResponse(List<User> users);


    // -------------------- REVERSE MAPPING ------------------ \\
}