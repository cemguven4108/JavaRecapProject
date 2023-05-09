package com.recap.carrental.business.concretes;

import com.recap.carrental.business.abstracts.BrandService;
import com.recap.carrental.business.mappers.abstracts.BrandDTOMapperService;
import com.recap.carrental.business.requests.brandRequests.BrandCreateRequest;
import com.recap.carrental.business.requests.brandRequests.BrandUpdateRequest;
import com.recap.carrental.business.responses.brandResponses.BrandGetAllResponse;
import com.recap.carrental.business.responses.brandResponses.BrandGetByIdResponse;
import com.recap.carrental.business.rules.BrandBusinessRules;
import com.recap.carrental.dataAccess.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;
    private final BrandDTOMapperService brandDTOMapperService;
    private final BrandBusinessRules brandBusinessRules;

    @Override
    public void create(BrandCreateRequest request) {
        this.brandBusinessRules.checkIfBrandNameExists(request.brandName());
        this.brandBusinessRules.checkIfBrandNameLengthIsValid(request.brandName());

        this.brandRepository.save(this.brandDTOMapperService.BrandCreateRequestToBrand(request));
    }

    @Override
    public void update(int brandId, BrandUpdateRequest request) {
        this.brandBusinessRules.checkIfBrandNameExists(request.brandName());
        this.brandBusinessRules.checkIfBrandNameLengthIsValid(request.brandName());

        this.brandRepository.save(this.brandDTOMapperService.BrandUpdateRequestToBrand(brandId, request));
    }

    @Override
    public void delete(int brandId) {
        this.brandRepository.deleteById(brandId);
    }

    @Override
    public BrandGetByIdResponse getById(int brandId) {
        return this.brandDTOMapperService.BrandToBrandGetByIdResponse(
                this.brandRepository.findById(brandId).orElseThrow()
        );
    }

    @Override
    public List<BrandGetAllResponse> getAll() {
        return this.brandDTOMapperService.BrandToBrandGetAllResponse(
                this.brandRepository.findAll()
        );
    }
}
