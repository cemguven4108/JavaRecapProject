package com.recap.carrental.business.mappers.concretes;

import com.recap.carrental.business.mappers.abstracts.UserDTOMapperService;
import com.recap.carrental.business.requests.userRequests.UserCreateRequest;
import com.recap.carrental.business.requests.userRequests.UserUpdateRequest;
import com.recap.carrental.business.responses.userResponses.UserGetAllResponse;
import com.recap.carrental.business.responses.userResponses.UserGetByIdResponse;
import com.recap.carrental.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDTOMapperManager implements UserDTOMapperService {
    @Override
    public User UserCreateRequestToUser(UserCreateRequest request) {
        User user = new User();
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setEmail(request.email());
        user.setPassword(request.password());

        return user;
    }

    @Override
    public User UserUpdateRequestToUser(int id, UserUpdateRequest request) {
        User user = new User();
        user.setId(id);
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setEmail(request.email());
        user.setPassword(request.password());

        return user;
    }

    @Override
    public UserGetByIdResponse UserToUserGetByIdResponse(User user) {
        return new UserGetByIdResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword()
        );
    }

    @Override
    public List<UserGetAllResponse> UserToUserGetAllResponse(List<User> users) {
        return users.stream()
                .map(user -> new UserGetAllResponse(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getPassword()
                )).collect(Collectors.toList());
    }


    // -------------------- REVERSE MAPPING ------------------ \\

    @Override
    public User GetByIdResponseToUser(int userId) {
        User user = new User();
        user.setId(userId);

        return user;
    }
}
