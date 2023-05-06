package com.recap.carrental.webApi.controllers;

import com.recap.carrental.business.abstracts.ColorService;
import com.recap.carrental.business.requests.colorRequests.ColorCreateRequest;
import com.recap.carrental.business.responses.colorResponses.ColorGetAllResponse;
import com.recap.carrental.business.responses.colorResponses.ColorGetByIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/colors")
public class ColorsController {

    private final ColorService colorService;

    @PostMapping(value = "/create")
    public String create(@RequestBody ColorCreateRequest request) {
        return this.colorService.create(request);
    }

    @GetMapping(value = "/{colorId}")
    public ColorGetByIdResponse getById(@PathVariable int colorId) {
        return this.colorService.getById(colorId);
    }

    @GetMapping(value = "/getAll")
    public List<ColorGetAllResponse> getAll() {
        return null;
    }
}
