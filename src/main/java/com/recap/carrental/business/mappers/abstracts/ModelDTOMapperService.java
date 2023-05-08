package com.recap.carrental.business.mappers.abstracts;

import com.recap.carrental.business.requests.modelRequests.ModelCreateRequest;
import com.recap.carrental.business.requests.modelRequests.ModelUpdateRequest;
import com.recap.carrental.business.responses.modelResponses.ModelGetAllResponse;
import com.recap.carrental.business.responses.modelResponses.ModelGetByIdResponse;
import com.recap.carrental.entities.Model;

import java.util.List;

public interface ModelDTOMapperService {
    Model ModelCreateRequestToModel(ModelCreateRequest request);
    Model ModelUpdateRequestToModel(int id, ModelUpdateRequest request);
    ModelGetByIdResponse ModelToModelGetByIdResponse(Model model);
    List<ModelGetAllResponse> ModelToModelGetAllResponse(List<Model> models);


    // -------------------- REVERSE MAPPING ------------------ \\

    Model ModelGetByIdResponseToModel(int modelId);
}
