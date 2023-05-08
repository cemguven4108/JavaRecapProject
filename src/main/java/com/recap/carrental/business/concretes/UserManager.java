package com.recap.carrental.business.concretes;

import com.recap.carrental.business.abstracts.UserService;
import com.recap.carrental.business.mappers.abstracts.UserDTOMapperService;
import com.recap.carrental.business.requests.userRequests.UserCreateRequest;
import com.recap.carrental.business.requests.userRequests.UserUpdateRequest;
import com.recap.carrental.business.responses.userResponses.UserGetAllResponse;
import com.recap.carrental.business.responses.userResponses.UserGetByIdResponse;
import com.recap.carrental.dataAccess.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final UserDTOMapperService userDTOMapperService;

    @Override
    public String create(UserCreateRequest request) {
        this.userRepository.save(this.userDTOMapperService.UserCreateRequestToUser(request));
        return this.userRepository.existsByEmail(request.email()) ? "Success" : "Failed";
    }

    @Override
    public String update(int id, UserUpdateRequest request) {
        this.userRepository.save(this.userDTOMapperService.UserUpdateRequestToUser(id, request));
        return "Success";
    }

    @Override
    public String delete(int id) {
        this.userRepository.deleteById(id);
        return this.userRepository.findById(id).isEmpty() ? "Success" : "Failed";
    }

    @Override
    public UserGetByIdResponse getById(int id) {
        return this.userDTOMapperService.UserToUserGetByIdResponse(
                this.userRepository.findById(id).orElseThrow()
        );
    }

    @Override
    public List<UserGetAllResponse> getAll() {
        return this.userDTOMapperService.UserToUserGetAllResponse(
                this.userRepository.findAll()
        );
    }
}
