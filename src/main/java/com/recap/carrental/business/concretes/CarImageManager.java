package com.recap.carrental.business.concretes;

import com.recap.carrental.business.abstracts.CarImageService;
import com.recap.carrental.business.requests.carImageRequests.CarImageCreateRequest;
import com.recap.carrental.business.responses.carImageResponses.CarImageGetAllResponse;
import com.recap.carrental.dataAccess.CarImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarImageManager implements CarImageService {

    private final CarImageRepository carImageRepository;

    @Override
    public String create(CarImageCreateRequest request) {
        return null;
    }

    @Override
    public List<CarImageGetAllResponse> getAll() {
        return null;
    }
}
