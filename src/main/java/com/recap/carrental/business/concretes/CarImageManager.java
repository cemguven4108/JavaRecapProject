package com.recap.carrental.business.concretes;

import com.recap.carrental.business.abstracts.CarImageService;
import com.recap.carrental.business.mappers.abstracts.CarImageDTOMapperService;
import com.recap.carrental.business.requests.carImageRequests.CarImageCreateRequest;
import com.recap.carrental.business.responses.carImageResponses.CarImageGetAllResponse;
import com.recap.carrental.dataAccess.CarImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarImageManager implements CarImageService {

    private final CarImageRepository carImageRepository;
    private final CarImageDTOMapperService carImageDTOMapperService;

    @Override
    public String create(CarImageCreateRequest request) {
        this.carImageRepository.save(this.carImageDTOMapperService.CarImageCreateRequestToCarImage(request));
        return this.carImageRepository.existsByCarId(request.carId()) ? "Success" : "Failed";
    }

    @Override
    public List<CarImageGetAllResponse> getAll() {
        return this.carImageDTOMapperService.CarImageToCarImageGetAllResponse(
                this.carImageRepository.findAll()
        );
    }
}
