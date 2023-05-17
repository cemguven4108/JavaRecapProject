package com.recap.carrental.webApi.controllers;

import com.recap.carrental.business.abstracts.BrandService;
import com.recap.carrental.business.requests.brandRequests.BrandCreateRequest;
import com.recap.carrental.business.requests.brandRequests.BrandUpdateRequest;
import com.recap.carrental.business.responses.brandResponses.BrandGetAllResponse;
import com.recap.carrental.business.responses.brandResponses.BrandGetByIdResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Brand")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/brands")
public class BrandsController {

    private final BrandService brandService;

    @PostMapping(value = "/create")
    public void create(@RequestBody @Valid BrandCreateRequest request) {
        this.brandService.create(request);
    }

    @PutMapping(value = "/update/{brandId}")
    public void update(@PathVariable int brandId, @RequestBody BrandUpdateRequest request) {
        this.brandService.update(brandId, request);
    }

    @DeleteMapping(value = "/delete/{brandId}")
    public void delete(@PathVariable int brandId) {
        this.brandService.delete(brandId);
    }

    @GetMapping(value = "/getById/{brandId}")
    public BrandGetByIdResponse getById(@PathVariable int brandId) {
        return this.brandService.getById(brandId);
    }

    @GetMapping(value = "/getAll")
    public List<BrandGetAllResponse> getAll() {
        return this.brandService.getAll();
    }
}
