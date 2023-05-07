package com.recap.carrental.business.mappers.concretes;

import com.recap.carrental.business.mappers.abstracts.ModelDTOMapperService;
import com.recap.carrental.business.requests.modelRequests.ModelCreateRequest;
import com.recap.carrental.business.requests.modelRequests.ModelUpdateRequest;
import com.recap.carrental.business.responses.modelResponses.ModelGetAllResponse;
import com.recap.carrental.business.responses.modelResponses.ModelGetByIdResponse;
import com.recap.carrental.entities.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public Model ModelUpdateRequestToModel(int id, ModelUpdateRequest request) {
        Model model = new Model();
        model.setId(id);
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

    @Override
    public List<ModelGetAllResponse> ModelToModelGetAllResponse(List<Model> models) {
        return models.stream()
                .map(model -> new ModelGetAllResponse(
                        model.getId(),
                        model.getModelName(),
                        model.getModelYear()
                )).collect(Collectors.toList());
    }
}
