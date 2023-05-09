package com.recap.carrental.webApi.controllers;

import com.recap.carrental.business.abstracts.CustomerService;
import com.recap.carrental.business.requests.customerRequests.CustomerCreateRequest;
import com.recap.carrental.business.requests.customerRequests.CustomerUpdateRequest;
import com.recap.carrental.business.responses.customerResponses.CustomerGetAllResponse;
import com.recap.carrental.business.responses.customerResponses.CustomerGetByIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/customers")
public class CustomersController {

    private final CustomerService customerService;

    @PostMapping(value = "/create")
    public String create(@RequestBody CustomerCreateRequest request) {
        return this.customerService.create(request);
    }

    @PutMapping(value = "/update/{id}")
    public String update(@PathVariable int id, @RequestBody CustomerUpdateRequest request) {
        return this.customerService.update(id, request);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id) {
        return this.customerService.delete(id);
    }

    @GetMapping(value = "/getById/{id}")
    public CustomerGetByIdResponse getById(@PathVariable int id) {
        return this.customerService.getById(id);
    }

    @GetMapping(value = "/getAll")
    public List<CustomerGetAllResponse> getAll() {
        return this.customerService.getAll();
    }
}
