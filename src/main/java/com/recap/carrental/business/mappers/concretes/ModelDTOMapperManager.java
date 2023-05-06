package com.recap.carrental.business.mappers.concretes;

import com.recap.carrental.business.mappers.abstracts.ModelDTOMapperService;
import com.recap.carrental.business.requests.modelRequests.ModelCreateRequest;
import com.recap.carrental.business.responses.modelResponses.ModelGetByIdResponse;
import com.recap.carrental.entities.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelDTOMapperManager implements ModelDTOMapperService {

    @Override
    public Model ModelCreateRequestToModel(ModelCreateRequest request) {
        Model model = new Model();
        model.setModelName(request.modelName());
        model.setModelYear(request.modelYear());

        return model;
    }

    @Override
    public ModelGetByIdResponse ModelToModelGetByIdResponse(Model model) {
        return new ModelGetByIdResponse(
                model.getId(),
                model.getModelName(),
                model.getModelYear()
        );
    }

    @Override
    public Model ModelGetByIdResponseToModel(ModelGetByIdResponse response) {
        Model model = new Model();
        model.setId(response.id());

        return model;
    }
}
