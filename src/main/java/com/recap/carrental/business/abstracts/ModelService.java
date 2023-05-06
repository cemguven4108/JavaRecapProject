package com.recap.carrental.business.abstracts;

import com.recap.carrental.business.requests.modelRequests.ModelCreateRequest;
import com.recap.carrental.business.responses.modelResponses.ModelGetByIdResponse;

public interface ModelService {
    String create(ModelCreateRequest request);
    ModelGetByIdResponse getById(int modelId);
}
