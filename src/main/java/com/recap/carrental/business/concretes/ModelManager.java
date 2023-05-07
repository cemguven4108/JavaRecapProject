package com.recap.carrental.business.concretes;

import com.recap.carrental.business.abstracts.ModelService;
import com.recap.carrental.business.mappers.abstracts.ModelDTOMapperService;
import com.recap.carrental.business.requests.modelRequests.ModelCreateRequest;
import com.recap.carrental.business.requests.modelRequests.ModelUpdateRequest;
import com.recap.carrental.business.responses.modelResponses.ModelGetAllResponse;
import com.recap.carrental.business.responses.modelResponses.ModelGetByIdResponse;
import com.recap.carrental.dataAccess.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public String update(int id, ModelUpdateRequest request) {
        this.modelRepository.save(this.modelDTOMapperService.ModelUpdateRequestToModel(id, request));
        return "Success";
    }

    @Override
    public String delete(int id) {
        this.modelRepository.deleteById(id);
        return this.modelRepository.findById(id).isEmpty() ? "Success" : "Failed";
    }

    @Override
    public ModelGetByIdResponse getById(int modelId) {
        return this.modelDTOMapperService.ModelToModelGetByIdResponse(
                this.modelRepository.findById(modelId).orElseThrow());
    }

    @Override
    public List<ModelGetAllResponse> getAll() {
        return this.modelDTOMapperService.ModelToModelGetAllResponse(
                this.modelRepository.findAll()
        );
    }
}
