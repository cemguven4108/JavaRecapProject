package com.recap.carrental.core.business.mappers.concretes;

import com.recap.carrental.core.business.mappers.abstracts.UserDTOMapperService;
import com.recap.carrental.core.business.requests.userRequests.UserCreateRequest;
import com.recap.carrental.core.business.requests.userRequests.UserUpdateRequest;
import com.recap.carrental.core.business.responses.userResponses.UserGetAllResponse;
import com.recap.carrental.core.business.responses.userResponses.UserGetByEmailResponse;
import com.recap.carrental.core.business.responses.userResponses.UserGetByIdResponse;
import com.recap.carrental.core.entities.User;
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
        user.setRole(request.role());

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
        user.setRole(request.role());

        return user;
    }

    @Override
    public UserGetByIdResponse UserToUserGetByIdResponse(User user) {
        return new UserGetByIdResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole()
        );
    }

    @Override
    public UserGetByEmailResponse UserToUserGetByEmailResponse(User user) {
        return new UserGetByEmailResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole()
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
                        user.getPassword(),
                        user.getRole()
                )).collect(Collectors.toList());
    }


    // -------------------- REVERSE MAPPING ------------------ \\

    @Override
    public User GetByIdResponseToUser(int userId) {
        User user = new User();
        user.setId(userId);

        return user;
    }

    @Override
    public User GetByEmailResponseToUser(int userId) {
        return this.GetByIdResponseToUser(userId);
    }
}
