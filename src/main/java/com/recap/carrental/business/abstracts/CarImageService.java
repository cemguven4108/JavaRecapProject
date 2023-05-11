package com.recap.carrental.business.abstracts;

import com.recap.carrental.business.requests.carImageRequests.CarImageCreateRequest;
import com.recap.carrental.business.responses.carImageResponses.CarImageGetAllResponse;
import com.recap.carrental.business.responses.carImageResponses.CarImageGetByIdResponse;

import java.util.List;

public interface CarImageService {
    String create(CarImageCreateRequest request);
    CarImageGetByIdResponse getById(int id);
    List<CarImageGetAllResponse> getAllByCarId(int carId);
}
