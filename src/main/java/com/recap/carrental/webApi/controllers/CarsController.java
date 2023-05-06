package com.recap.carrental.webApi.controllers;

import com.recap.carrental.business.abstracts.CarService;
import com.recap.carrental.business.requests.carRequests.CarCreateRequest;
import com.recap.carrental.business.requests.carRequests.CarUpdateRequest;
import com.recap.carrental.business.responses.carResponses.CarGetAllResponse;
import com.recap.carrental.business.responses.carResponses.CarGetByIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/cars")
public class CarsController {

    private final CarService carService;

    @PostMapping(value = "/create")
    public String create(@RequestBody CarCreateRequest request) {
        return this.carService.create(request);
    }

    @PutMapping(value = "/update")
    public String update(@RequestBody CarUpdateRequest request) {
        return this.carService.update(request);
    }

    @DeleteMapping(value = "delete/{id}")
    public String delete(@PathVariable int id) {
        return this.carService.delete(id);
    }

    @GetMapping(value = "/getById/{id}")
    public CarGetByIdResponse getById(@PathVariable int id) {
        return this.carService.getById(id);
    }
    @GetMapping(value = "/getAll")
    public List<CarGetAllResponse> getAll() {
        return this.carService.getAll();
    }

    @GetMapping(value = "/getAllByModel/{modelId}")
    public List<CarGetAllResponse> getAllByModel(@PathVariable int modelId) {
        return this.carService.getAllByModel(modelId);
    }

    @GetMapping(value = "/getAllByModel/{colorId}")
    public List<CarGetAllResponse> getAllByColor(@PathVariable int colorId) {
        return this.carService.getAllByColor(colorId);
    }
}
