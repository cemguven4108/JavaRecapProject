package com.recap.carrental.business.concretes;

import com.recap.carrental.business.abstracts.CarService;
import com.recap.carrental.business.mappers.abstracts.CarDTOMapperService;
import com.recap.carrental.business.requests.carRequests.CarCreateRequest;
import com.recap.carrental.business.requests.carRequests.CarUpdateRequest;
import com.recap.carrental.business.responses.carResponses.CarGetAllResponse;
import com.recap.carrental.business.responses.carResponses.CarGetByIdResponse;
import com.recap.carrental.dataAccess.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarManager implements CarService {

    private final CarRepository carRepository;
    private final CarDTOMapperService carDTOMapperService;

    @Override
    public String create(CarCreateRequest request) {
        this.carRepository.save(this.carDTOMapperService.CarCreateRequestToCar(request));
        return this.carRepository.existsByPlateNumber(request.plateNumber()) ? "Success" : "Failed";
    }

    @Override
    public String update(CarUpdateRequest request) {
        return null;
    }

    @Override
    public String delete(int id) {
        this.carRepository.deleteById(id);
        return this.carRepository.existsById(id) ? "Failed" : "Success";
    }

    @Override
    public CarGetByIdResponse getById(int id) {
        return this.carDTOMapperService.CarToCarGetByIdResponse(
                this.carRepository.findById(id).orElseThrow());
    }

    @Override
    public List<CarGetAllResponse> getAll() {
        return this.carDTOMapperService.CarToCarGetAllResponse(
                this.carRepository.findAll());
    }

    @Override
    public List<CarGetAllResponse> getAllByModel(int modelId) {
        return this.carDTOMapperService.CarToCarGetAllResponse(
                this.carRepository.findAllByModel_Id(modelId));
    }

    @Override
    public List<CarGetAllResponse> getAllByColor(int colorId) {
        return this.carDTOMapperService.CarToCarGetAllResponse(
                this.carRepository.findAllByColor_Id(colorId));
    }
}
