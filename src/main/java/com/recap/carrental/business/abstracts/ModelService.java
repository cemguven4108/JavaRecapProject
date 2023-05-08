package com.recap.carrental.business.abstracts;

import com.recap.carrental.business.requests.modelRequests.ModelCreateRequest;
import com.recap.carrental.business.requests.modelRequests.ModelUpdateRequest;
import com.recap.carrental.business.responses.modelResponses.ModelGetAllResponse;
import com.recap.carrental.business.responses.modelResponses.ModelGetByIdResponse;

import java.util.List;

public interface ModelService {
    String create(ModelCreateRequest request);
    String update(int id, ModelUpdateRequest request);
    String delete(int id);
    ModelGetByIdResponse getById(int modelId);
    List<ModelGetAllResponse> getAll();
    List<ModelGetAllResponse> getAllByBrand(int brandId);
}
