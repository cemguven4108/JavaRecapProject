package com.recap.carrental.business.mappers.concretes;

import com.recap.carrental.business.mappers.abstracts.CarDTOMapperService;
import com.recap.carrental.business.mappers.abstracts.CarImageDTOMapperService;
import com.recap.carrental.business.requests.carImageRequests.CarImageCreateRequest;
import com.recap.carrental.business.responses.carImageResponses.CarImageGetAllResponse;
import com.recap.carrental.business.responses.carImageResponses.CarImageGetByIdResponse;
import com.recap.carrental.entities.CarImage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarImageDTOMapperManager implements CarImageDTOMapperService {

    private final CarDTOMapperService carDTOMapperService;

    @Override
    public CarImage CarImageCreateRequestToCarImage(CarImageCreateRequest request) {
        CarImage carImage = new CarImage();
        carImage.setImagePath(request.imagePath());
        carImage.setCreationTime(request.timestamp());
        carImage.setCar(this.carDTOMapperService.CarGetByIdResponseToCar(request.carId()));

        return carImage;
    }

    @Override
    public CarImageGetByIdResponse CarImageToCarImageGetByIdResponse(CarImage carImage) {
        return new CarImageGetByIdResponse(
                carImage.getId(),
                carImage.getCar().getId(),
                carImage.getImagePath(),
                carImage.getCreationTime()
        );
    }

    @Override
    public List<CarImageGetAllResponse> CarImageToCarImageGetAllResponse(List<CarImage> carImages) {
        return carImages.stream()
                .map(carImage -> new CarImageGetAllResponse(
                        carImage.getId(),
                        carImage.getCar().getId(),
                        carImage.getImagePath(),
                        carImage.getCreationTime()
                )).collect(Collectors.toList());
    }
}
