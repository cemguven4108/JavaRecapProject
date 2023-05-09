package com.recap.carrental.business.abstracts;

import com.recap.carrental.business.requests.rentalRequests.RentalCreateRequest;
import com.recap.carrental.business.requests.rentalRequests.RentalUpdateRequest;
import com.recap.carrental.business.responses.rentalResponses.RentalGetAllResponse;
import com.recap.carrental.business.responses.rentalResponses.RentalGetByIdResponse;

import java.util.List;

public interface RentalService {
    String create(RentalCreateRequest request);
    String update(int id, RentalUpdateRequest request);
    String delete(int id);
    RentalGetByIdResponse getById(int id);
    List<RentalGetAllResponse> getAll();
}
