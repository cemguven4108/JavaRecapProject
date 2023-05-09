package com.recap.carrental.business.abstracts;

import com.recap.carrental.business.requests.brandRequests.BrandCreateRequest;
import com.recap.carrental.business.requests.brandRequests.BrandUpdateRequest;
import com.recap.carrental.business.responses.brandResponses.BrandGetAllResponse;
import com.recap.carrental.business.responses.brandResponses.BrandGetByIdResponse;
import java.util.List;

public interface BrandService {
    void create(BrandCreateRequest request);
    void update(int brandId, BrandUpdateRequest request);
    void delete(int brandId);
    BrandGetByIdResponse getById(int brandId);
    List<BrandGetAllResponse> getAll();
}
