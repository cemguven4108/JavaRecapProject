package com.recap.carrental.business.mappers.abstracts;

import com.recap.carrental.business.requests.carImageRequests.CarImageCreateRequest;
import com.recap.carrental.business.responses.carImageResponses.CarImageGetAllResponse;
import com.recap.carrental.entities.CarImage;

import java.util.List;

public interface CarImageDTOMapperService {
    CarImage CarImageCreateRequestToCarImage(CarImageCreateRequest request);
    List<CarImageGetAllResponse> CarImageToCarImageGetAllResponse(List<CarImage> carImages);
}