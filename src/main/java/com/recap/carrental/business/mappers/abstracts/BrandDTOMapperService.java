package com.recap.carrental.business.mappers.abstracts;

import com.recap.carrental.business.requests.brandRequests.BrandCreateRequest;
import com.recap.carrental.business.requests.brandRequests.BrandUpdateRequest;
import com.recap.carrental.business.responses.brandResponses.BrandGetAllResponse;
import com.recap.carrental.business.responses.brandResponses.BrandGetByIdResponse;
import com.recap.carrental.entities.Brand;

import java.util.List;

public interface BrandDTOMapperService {
    Brand BrandCreateRequestToBrand(BrandCreateRequest request);
    Brand BrandUpdateRequestToBrand(int brandId, BrandUpdateRequest request);
    BrandGetByIdResponse BrandToBrandGetByIdResponse(Brand brand);
    List<BrandGetAllResponse> BrandToBrandGetAllResponse(List<Brand> brands);


    // -------------------- REVERSE MAPPING ------------------ \\
    Brand GetByIdResponseToBrand(int brandId);
}
