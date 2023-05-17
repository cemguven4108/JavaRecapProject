package com.recap.carrental.webApi.controllers;

import com.recap.carrental.business.abstracts.RentalService;
import com.recap.carrental.business.requests.rentalRequests.RentalCreateRequest;
import com.recap.carrental.business.requests.rentalRequests.RentalUpdateRequest;
import com.recap.carrental.business.responses.rentalResponses.RentalGetAllResponse;
import com.recap.carrental.business.responses.rentalResponses.RentalGetByIdResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Rental")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/rentals")
public class RentalsController {

    private final RentalService rentalService;

    @PostMapping(value = "/create")
    public String create(RentalCreateRequest request) {
        return this.rentalService.create(request);
    }

    @PutMapping(value = "/update/{id}")
    public String update(@PathVariable int id, @RequestBody RentalUpdateRequest request) {
        return this.rentalService.update(id, request);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id) {
        return this.rentalService.delete(id);
    }

    @GetMapping(value = "/getById/{id}")
    public RentalGetByIdResponse getById(@PathVariable int id) {
        return this.rentalService.getById(id);
    }

    @GetMapping(value = "/getAll")
    public List<RentalGetAllResponse> getAll() {
        return this.rentalService.getAll();
    }
}
