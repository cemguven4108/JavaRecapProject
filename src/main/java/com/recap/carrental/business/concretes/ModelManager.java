package com.recap.carrental.business.concretes;

import com.recap.carrental.business.abstracts.ModelService;
import com.recap.carrental.business.mappers.abstracts.ModelDTOMapperService;
import com.recap.carrental.business.requests.modelRequests.ModelCreateRequest;
import com.recap.carrental.business.responses.modelResponses.ModelGetByIdResponse;
import com.recap.carrental.dataAccess.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelManager implements ModelService {

    private final ModelRepository modelRepository;
    private final ModelDTOMapperService modelDTOMapperService;

    @Override
    public String create(ModelCreateRequest request) {
        this.modelRepository.save(this.modelDTOMapperService.ModelCreateRequestToModel(request));
        return this.modelRepository.existsByModelName(request.modelName()) ? "Success" : "Failed";
    }

    @Override
    public ModelGetByIdResponse getById(int modelId) {
        return this.modelDTOMapperService.ModelToModelGetByIdResponse(
                this.modelRepository.findById(modelId).orElseThrow());
    }
}
