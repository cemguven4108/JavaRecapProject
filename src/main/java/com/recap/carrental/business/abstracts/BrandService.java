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

    BrandGetByIdResponse getByBrandName(String brandName);

    List<BrandGetAllResponse> getAll();

    List<BrandGetAllResponse> getAll(int page);

    List<BrandGetAllResponse> getAll(int page, String sortBy);

    List<BrandGetAllResponse> getAll(int page, int size);

    List<BrandGetAllResponse> getAll(int page, int size, String sortBy);
}
