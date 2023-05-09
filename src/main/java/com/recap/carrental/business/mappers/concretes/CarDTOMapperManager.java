package com.recap.carrental.business.mappers.concretes;

import com.recap.carrental.business.mappers.abstracts.CarDTOMapperService;
import com.recap.carrental.business.mappers.abstracts.ColorDTOMapperService;
import com.recap.carrental.business.mappers.abstracts.ModelDTOMapperService;
import com.recap.carrental.business.requests.carRequests.CarCreateRequest;
import com.recap.carrental.business.requests.carRequests.CarUpdateRequest;
import com.recap.carrental.business.responses.carResponses.CarGetAllResponse;
import com.recap.carrental.business.responses.carResponses.CarGetByIdResponse;
import com.recap.carrental.entities.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarDTOMapperManager implements CarDTOMapperService {
    private final ModelDTOMapperService modelDTOMapperService;
    private final ColorDTOMapperService colorDTOMapperService;

    @Override
    public Car CarCreateRequestToCar(CarCreateRequest request) {

        Car car = new Car();
        car.setPlateNumber(request.plateNumber());
        car.setDailyPrice(request.dailyPrice());
        car.setState(request.state());
        car.setDescription(request.description());
        car.setModel(
                this.modelDTOMapperService.ModelGetByIdResponseToModel(request.modelId()));
        car.setColor(
                this.colorDTOMapperService.ColorGetByIdResponseToColor(request.colorId()));
        return car;
    }

    @Override
    public Car CarUpdateRequestToCar(int id, CarUpdateRequest request) {
        Car car = new Car();
        car.setId(id);
        car.setPlateNumber(request.plateNumber());
        car.setDailyPrice(request.dailyPrice());
        car.setState(request.state());
        car.setDescription(request.description());
        car.setModel(
                this.modelDTOMapperService.ModelGetByIdResponseToModel(request.modelId()));
        car.setColor(
                this.colorDTOMapperService.ColorGetByIdResponseToColor(request.colorId()));
        return car;
    }

    @Override
    public CarGetByIdResponse CarToCarGetByIdResponse(Car car) {
        return new CarGetByIdResponse(
                car.getId(),
                car.getPlateNumber(),
                car.getModel().getBrand().getBrandName(),
                car.getModel().getModelName(),
                car.getModel().getModelYear(),
                car.getColor().getColorName(),
                car.getDailyPrice(),
                car.getState(),
                car.getDescription()
        );
    }

    @Override
    public List<CarGetAllResponse> CarToCarGetAllResponse(List<Car> cars) {
        return cars.stream()
                .map(car -> new CarGetAllResponse(
                        car.getId(),
                        car.getPlateNumber(),
                        car.getModel().getBrand().getBrandName(),
                        car.getModel().getModelName(),
                        car.getModel().getModelYear(),
                        car.getColor().getColorName(),
                        car.getDailyPrice(),
                        car.getState(),
                        car.getDescription()
                )).collect(Collectors.toList());
    }


    // -------------------- REVERSE MAPPING ------------------ \\

    @Override
    public Car CarGetByIdResponseToCar(int carId) {
        Car car = new Car();
        car.setId(carId);

        return car;
    }
}
