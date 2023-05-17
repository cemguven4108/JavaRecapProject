package com.recap.carrental.webApi.controllers;

import com.recap.carrental.business.abstracts.CarImageService;
import com.recap.carrental.business.requests.carImageRequests.CarImageCreateRequest;
import com.recap.carrental.business.responses.carImageResponses.CarImageGetAllResponse;
import com.recap.carrental.core.webApi.controllers.FileController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.ZonedDateTime;
import java.util.List;

@Tag(name = "CarImage")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/carImages")
public class CarImagesController {

    private final CarImageService carImageService;
    private final FileController fileController;

    @PostMapping(value = "/create/{carId}")
    public String create(@PathVariable int carId, @RequestParam("image") MultipartFile file) {
        String filename = this.fileController.uploadFile(file);
        return this.carImageService.create(
                new CarImageCreateRequest(
                        carId,
                        filename,
                        ZonedDateTime.now()
                )
        );
    }

    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id) {
        return this.carImageService.delete(id);
    }

    @GetMapping(value = "/getAllByCar/{carId}")
    public List<CarImageGetAllResponse> getAllByCarId(@PathVariable int carId) {
        return this.carImageService.getAllByCarId(carId);
    }
}
