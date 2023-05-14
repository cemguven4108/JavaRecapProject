package com.recap.carrental.core.business.mappers.abstracts;

import com.recap.carrental.core.business.requests.userRequests.UserCreateRequest;
import com.recap.carrental.core.business.requests.userRequests.UserUpdateRequest;
import com.recap.carrental.core.business.responses.userResponses.UserGetAllResponse;
import com.recap.carrental.core.business.responses.userResponses.UserGetByEmailResponse;
import com.recap.carrental.core.business.responses.userResponses.UserGetByIdResponse;
import com.recap.carrental.core.entities.User;

import java.util.List;

public interface UserDTOMapperService {
    User UserCreateRequestToUser(UserCreateRequest request);
    User UserUpdateRequestToUser(int id, UserUpdateRequest request);
    UserGetByIdResponse UserToUserGetByIdResponse(User user);
    UserGetByEmailResponse UserToUserGetByEmailResponse(User user);
    List<UserGetAllResponse> UserToUserGetAllResponse(List<User> users);


    // -------------------- REVERSE MAPPING ------------------ \\

    User GetByIdResponseToUser(int userId);
    User GetByEmailResponseToUser(int userId);
}