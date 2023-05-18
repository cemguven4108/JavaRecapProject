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

    @GetMapping(value = "/getByBrandName/{brandName}")
    public BrandGetByIdResponse getByBrandName(@PathVariable String brandName) {
        return this.brandService.getByBrandName(brandName);
    }

    @GetMapping(value = "/getAll")
    public List<BrandGetAllResponse> getAll() {
        return this.brandService.getAll();
    }

    @GetMapping(value = "/getAllSorted")
    public List<BrandGetAllResponse> getAll(@RequestParam int page, @RequestParam String sortBy) {
        return this.brandService.getAll(page, sortBy);
    }

    @GetMapping(value = "/getAllPage")
    public List<BrandGetAllResponse> getAll(@RequestParam int page) {
        return this.brandService.getAll(page);
    }

    @GetMapping(value = "/getAllPageAndSize")
    public List<BrandGetAllResponse> getAll(@RequestParam int page, @RequestParam int size) {
        return this.brandService.getAll(page, size);
    }

    @GetMapping(value = "/getAllSortedPageAndSize")
    public List<BrandGetAllResponse> getAll(@RequestParam int page, @RequestParam int size, @RequestParam String sortBy) {
        return this.brandService.getAll(page, size, sortBy);
    }
}
