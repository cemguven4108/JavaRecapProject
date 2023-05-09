package com.recap.carrental.business.mappers.abstracts;

import com.recap.carrental.business.requests.carRequests.CarCreateRequest;
import com.recap.carrental.business.requests.carRequests.CarUpdateRequest;
import com.recap.carrental.business.responses.carResponses.CarGetAllResponse;
import com.recap.carrental.business.responses.carResponses.CarGetByIdResponse;
import com.recap.carrental.entities.Car;

import java.util.List;

public interface CarDTOMapperService {
    Car CarCreateRequestToCar(CarCreateRequest request);
    Car CarUpdateRequestToCar(int id, CarUpdateRequest request);
    CarGetByIdResponse CarToCarGetByIdResponse(Car car);
    List<CarGetAllResponse> CarToCarGetAllResponse(List<Car> cars);


    // -------------------- REVERSE MAPPING ------------------ \\

    Car CarGetByIdResponseToCar(int carId);
}
