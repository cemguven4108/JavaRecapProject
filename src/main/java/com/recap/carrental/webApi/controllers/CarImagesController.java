package com.recap.carrental.webApi.controllers;

import com.recap.carrental.business.abstracts.CarImageService;
import com.recap.carrental.business.requests.carImageRequests.CarImageCreateRequest;
import com.recap.carrental.core.utilities.fileHelpers.FileController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.ZonedDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/carImages")
public class CarImagesController {

    private final CarImageService carImageService;
    private final FileController fileController;

    @PostMapping(value = "/create")
    public String create(@RequestParam MultipartFile file) {
        String filename = this.fileController.uploadFile(file);
        return this.carImageService.create(
                new CarImageCreateRequest(
                        filename,
                        ZonedDateTime.now()
                )
        );
    }
}
