package com.recap.carrental.business.concretes;

import com.recap.carrental.business.abstracts.CarImageService;
import com.recap.carrental.business.mappers.abstracts.CarImageDTOMapperService;
import com.recap.carrental.business.requests.carImageRequests.CarImageCreateRequest;
import com.recap.carrental.business.responses.carImageResponses.CarImageGetAllResponse;
import com.recap.carrental.business.responses.carImageResponses.CarImageGetByIdResponse;
import com.recap.carrental.core.utilities.fileHelpers.FileService;
import com.recap.carrental.dataAccess.CarImageRepository;
import com.recap.carrental.entities.CarImage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarImageManager implements CarImageService {

    private final CarImageRepository carImageRepository;
    private final CarImageDTOMapperService carImageDTOMapperService;
    private final FileService fileService;

    @Override
    public String create(CarImageCreateRequest request) {
        this.carImageRepository.save(this.carImageDTOMapperService.CarImageCreateRequestToCarImage(request));
        return this.carImageRepository.existsByCarId(request.carId()) ? request.imagePath() : "Failed";
    }

    @Override
    public String delete(int id) {
        CarImage image = this.carImageRepository.findById(id).orElseThrow();
        this.fileService.delete(image.getImagePath());
        this.carImageRepository.delete(image);

        return this.carImageRepository.findById(id).isEmpty() ? "Success" : "Failed";
    }

    @Override
    public CarImageGetByIdResponse getById(int id) {
        return this.carImageDTOMapperService.CarImageToCarImageGetByIdResponse(
                this.carImageRepository.findById(id).orElseThrow()
        );
    }
    @Override
    public List<CarImageGetAllResponse> getAllByCarId(int carId) {
        return this.carImageDTOMapperService.CarImageToCarImageGetAllResponse(
                this.carImageRepository.findAllByCarId(carId)
        );
    }
}
