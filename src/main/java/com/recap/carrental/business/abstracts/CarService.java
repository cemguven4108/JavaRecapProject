package com.recap.carrental.business.abstracts;

import com.recap.carrental.business.requests.carRequests.CarCreateRequest;
import com.recap.carrental.business.requests.carRequests.CarUpdateRequest;
import com.recap.carrental.business.responses.carResponses.CarGetAllResponse;
import com.recap.carrental.business.responses.carResponses.CarGetByIdResponse;

import java.util.List;

public interface CarService {
    String create(CarCreateRequest request);
    String update(CarUpdateRequest request);
    String delete(int id);
    CarGetByIdResponse getById(int id);
    List<CarGetAllResponse> getAll();
    List<CarGetAllResponse> getAllByModel(int modelId);
    List<CarGetAllResponse> getAllByColor(int colorId);
}
