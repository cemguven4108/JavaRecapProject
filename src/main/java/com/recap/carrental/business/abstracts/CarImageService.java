package com.recap.carrental.business.abstracts;

import com.recap.carrental.business.requests.carImageRequests.CarImageCreateRequest;
import com.recap.carrental.business.responses.carImageResponses.CarImageGetAllResponse;

import java.util.List;

public interface CarImageService {
    String create(CarImageCreateRequest request);
    List<CarImageGetAllResponse> getAll();
}
