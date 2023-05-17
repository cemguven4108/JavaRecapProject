package com.recap.carrental.webApi.controllers;

import com.recap.carrental.business.abstracts.ModelService;
import com.recap.carrental.business.requests.modelRequests.ModelCreateRequest;
import com.recap.carrental.business.requests.modelRequests.ModelUpdateRequest;
import com.recap.carrental.business.responses.modelResponses.ModelGetAllResponse;
import com.recap.carrental.business.responses.modelResponses.ModelGetByIdResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Model")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/models")
public class ModelsController {

    private final ModelService modelService;

    @PostMapping(value = "/create")
    public String create(@RequestBody ModelCreateRequest request) {
        return this.modelService.create(request);
    }

    @PutMapping(value = "/update/{modelId}")
    public String update(@PathVariable int modelId, @RequestBody ModelUpdateRequest request) {
        return this.modelService.update(modelId, request);
    }

    @DeleteMapping(value = "/delete/{modelId}")
    public String delete(@PathVariable int modelId) {
        return this.modelService.delete(modelId);
    }

    @GetMapping(value = "/getById/{modelId}")
    public ModelGetByIdResponse getById(@PathVariable int modelId) {
        return this.modelService.getById(modelId);
    }

    @GetMapping(value = "/getAll")
    public List<ModelGetAllResponse> getAll() {
        return this.modelService.getAll();
    }

    @GetMapping(value = "/getAllByBrand/{brandId}")
    public List<ModelGetAllResponse> getAllByBrand(@PathVariable int brandId) {
        return this.modelService.getAllByBrand(brandId);
    }
}
