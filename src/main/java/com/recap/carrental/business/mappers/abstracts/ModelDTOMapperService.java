package com.recap.carrental.business.mappers.abstracts;

import com.recap.carrental.business.requests.modelRequests.ModelCreateRequest;
import com.recap.carrental.business.responses.modelResponses.ModelGetByIdResponse;
import com.recap.carrental.entities.Model;

public interface ModelDTOMapperService {

    Model ModelCreateRequestToModel(ModelCreateRequest request);
    ModelGetByIdResponse ModelToModelGetByIdResponse(Model model);
    Model ModelGetByIdResponseToModel(ModelGetByIdResponse response);
}
