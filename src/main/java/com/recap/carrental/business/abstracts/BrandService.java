package com.recap.carrental.business.abstracts;

import com.recap.carrental.business.requests.brandRequests.BrandCreateRequest;
import com.recap.carrental.business.requests.brandRequests.BrandUpdateRequest;
import com.recap.carrental.business.responses.brandResponses.BrandGetAllResponse;
import com.recap.carrental.business.responses.brandResponses.BrandGetByIdResponse;
import java.util.List;

public interface BrandService {
    String create(BrandCreateRequest request);
    String update(int brandId, BrandUpdateRequest request);
    String delete(int brandId);
    BrandGetByIdResponse getById(int brandId);
    List<BrandGetAllResponse> getAll();
}
