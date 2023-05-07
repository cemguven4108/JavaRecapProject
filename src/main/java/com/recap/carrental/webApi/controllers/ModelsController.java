package com.recap.carrental.webApi.controllers;

import com.recap.carrental.business.abstracts.ModelService;
import com.recap.carrental.business.requests.modelRequests.ModelCreateRequest;
import com.recap.carrental.business.requests.modelRequests.ModelUpdateRequest;
import com.recap.carrental.business.responses.modelResponses.ModelGetAllResponse;
import com.recap.carrental.business.responses.modelResponses.ModelGetByIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/models")
public class ModelsController {

    private final ModelService modelService;

    @PostMapping(value = "/create")
    public String create(@RequestBody ModelCreateRequest request) {
        return this.modelService.create(request);
    }

    @PutMapping(value = "/update/{id}")
    public String update(@PathVariable int id, @RequestBody ModelUpdateRequest request) {
        return this.modelService.update(id, request);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id) {
        return this.modelService.delete(id);
    }

    @GetMapping(value = "/{modelId}")
    public ModelGetByIdResponse getById(@PathVariable int modelId) {
        return this.modelService.getById(modelId);
    }

    @GetMapping(value = "/getAll")
    public List<ModelGetAllResponse> getAll() {
        return this.modelService.getAll();
    }
}
