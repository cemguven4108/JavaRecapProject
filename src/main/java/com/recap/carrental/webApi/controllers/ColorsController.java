package com.recap.carrental.webApi.controllers;

import com.recap.carrental.business.abstracts.ColorService;
import com.recap.carrental.business.requests.colorRequests.ColorCreateRequest;
import com.recap.carrental.business.requests.colorRequests.ColorUpdateRequest;
import com.recap.carrental.business.responses.colorResponses.ColorGetAllResponse;
import com.recap.carrental.business.responses.colorResponses.ColorGetByIdResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Color")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/colors")
public class ColorsController {

    private final ColorService colorService;

    @PostMapping(value = "/create")
    public String create(@RequestBody ColorCreateRequest request) {
        return this.colorService.create(request);
    }

    @PutMapping(value = "/update/{colorId}")
    public String update(@PathVariable int colorId, @RequestBody ColorUpdateRequest request) {
        return this.colorService.update(colorId, request);
    }

    @DeleteMapping(value = "/delete/{colorId}")
    public String delete(@PathVariable int colorId) {
        return this.colorService.delete(colorId);
    }

    @GetMapping(value = "/getById/{colorId}")
    public ColorGetByIdResponse getById(@PathVariable int colorId) {
        return this.colorService.getById(colorId);
    }

    @GetMapping(value = "/getAll")
    public List<ColorGetAllResponse> getAll() {
        return this.colorService.getAll();
    }
}
