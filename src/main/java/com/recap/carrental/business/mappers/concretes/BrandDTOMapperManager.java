package com.recap.carrental.business.mappers.concretes;

import com.recap.carrental.business.mappers.abstracts.BrandDTOMapperService;
import com.recap.carrental.business.requests.brandRequests.BrandCreateRequest;
import com.recap.carrental.business.requests.brandRequests.BrandUpdateRequest;
import com.recap.carrental.business.responses.brandResponses.BrandGetAllResponse;
import com.recap.carrental.business.responses.brandResponses.BrandGetByIdResponse;
import com.recap.carrental.entities.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandDTOMapperManager implements BrandDTOMapperService {

    @Override
    public Brand BrandCreateRequestToBrand(BrandCreateRequest request) {
        Brand brand = new Brand();
        brand.setBrandName(request.brandName());

        return brand;
    }

    @Override
    public Brand BrandUpdateRequestToBrand(int brandId, BrandUpdateRequest request) {
        Brand brand = new Brand();
        brand.setId(brandId);
        brand.setBrandName(request.brandName());

        return brand;
    }

    @Override
    public BrandGetByIdResponse BrandToBrandGetByIdResponse(Brand brand) {
        return new BrandGetByIdResponse(
                brand.getId(),
                brand.getBrandName()
        );
    }

    @Override
    public List<BrandGetAllResponse> BrandToBrandGetAllResponse(List<Brand> brands) {
        return brands.stream()
                .map(brand -> new BrandGetAllResponse(
                        brand.getId(),
                        brand.getBrandName()
                )).collect(Collectors.toList());
    }


    // -------------------- REVERSE MAPPING ------------------ \\
    @Override
    public Brand GetByIdResponseToBrand(int brandId) {
        Brand brand = new Brand();
        brand.setId(brandId);

        return brand;
    }
}
