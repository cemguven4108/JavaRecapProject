package com.recap.carrental.business.concretes;

import com.recap.carrental.business.abstracts.BrandService;
import com.recap.carrental.business.mappers.abstracts.BrandDTOMapperService;
import com.recap.carrental.business.requests.brandRequests.BrandCreateRequest;
import com.recap.carrental.business.requests.brandRequests.BrandUpdateRequest;
import com.recap.carrental.business.responses.brandResponses.BrandGetAllResponse;
import com.recap.carrental.business.responses.brandResponses.BrandGetByIdResponse;
import com.recap.carrental.business.rules.BrandBusinessRules;
import com.recap.carrental.core.utilities.exceptions.runtimeExceptions.EntityDoesNotExistException;
import com.recap.carrental.dataAccess.BrandRepository;
import com.recap.carrental.entities.Brand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;
    private final BrandDTOMapperService brandDTOMapperService;
    private final BrandBusinessRules brandBusinessRules;

    @Value("${application.requests.pageable.size}")
    private int defaultPageSize;

    @Override
    public void create(BrandCreateRequest request) {
        log.atInfo().log("Running BusinessRules For BrandManager Create Method");

        this.brandBusinessRules.checkIfBrandNameExists(request.brandName());
        this.brandBusinessRules.checkIfBrandNameLengthIsValid(request.brandName());

        log.atInfo().log("Complete BusinessRules For BrandManager Create Method");

        this.brandRepository.save(this.brandDTOMapperService.BrandCreateRequestToBrand(request));
    }

    @Override
    public void update(int brandId, BrandUpdateRequest request) {
        log.atInfo().log("Running BusinessRules For BrandManager Update Method");

        this.brandBusinessRules.checkIfBrandNameExists(request.brandName());
        this.brandBusinessRules.checkIfBrandNameLengthIsValid(request.brandName());

        log.atInfo().log("Complete BusinessRules For BrandManager Update Method");

        this.brandRepository.save(this.brandDTOMapperService.BrandUpdateRequestToBrand(brandId, request));
    }

    @Override
    public void delete(int brandId) {
        log.atInfo().log("Running BusinessRules For BrandManager Delete Method");

        this.brandBusinessRules.checkIfBrandExists(brandId);

        log.atInfo().log("Complete BusinessRules For BrandManager Delete Method");

        this.brandRepository.deleteById(brandId);
    }

    @Override
    public BrandGetByIdResponse getById(int brandId) {
        log.atInfo().log("Fetching Brand From Database");
        Brand brand = this.brandRepository.findById(brandId).orElseThrow(() ->
                new EntityDoesNotExistException(String.format("Brand with %s id does not exist", brandId)));

        log.atInfo().log("Returning Brand Data");
        return this.brandDTOMapperService.BrandToBrandGetByIdResponse(brand);
    }

    @Override
    public BrandGetByIdResponse getByBrandName(String brandName) {
        log.atInfo().log("Running BusinessRules For BrandManager GetByBrandName Method");
        this.brandBusinessRules.checkIfBrandNameExists(brandName);

        log.atInfo().log("Fetching Brand From Database");
        Brand brand = this.brandRepository.findByBrandName(brandName);

        log.atInfo().log("Returning Brand Data");
        return this.brandDTOMapperService.BrandToBrandGetByIdResponse(brand);
    }

    @Override
    public List<BrandGetAllResponse> getAll() {
        log.atInfo().log("Fetching Brands From Database");
        List<Brand> brands = this.brandRepository.findAll(Pageable.ofSize(defaultPageSize)).getContent();

        log.atInfo().log("Returning List<Brand> Data");
        return this.brandDTOMapperService.BrandToBrandGetAllResponse(brands);
    }

    @Override
    public List<BrandGetAllResponse> getAll(int page) {
        log.atInfo().log("Fetching Brands From Database");
        List<Brand> brands = this.brandRepository.findAll(PageRequest.of(page, defaultPageSize)).getContent();

        log.atInfo().log("Returning List<Brand> Data");
        return this.brandDTOMapperService.BrandToBrandGetAllResponse(brands);
    }

    @Override
    public List<BrandGetAllResponse> getAll(int page, String sortBy) {
        log.atInfo().log("Fetching Brands From Database");
        List<Brand> brands = this.brandRepository.findAll(PageRequest.of(page, defaultPageSize, Sort.by(sortBy))).getContent();

        log.atInfo().log("Returning List<Brand> Data");
        return this.brandDTOMapperService.BrandToBrandGetAllResponse(brands);
    }

    @Override
    public List<BrandGetAllResponse> getAll(int page, int size) {
        log.atInfo().log("Fetching Brands From Database");
        List<Brand> brands = this.brandRepository.findAll(PageRequest.of(page, size)).getContent();

        log.atInfo().log("Returning List<Brand> Data");
        return this.brandDTOMapperService.BrandToBrandGetAllResponse(brands);
    }

    @Override
    public List<BrandGetAllResponse> getAll(int page, int size, String sortBy) {
        log.atInfo().log("Fetching Brands From Database");
        List<Brand> brands = this.brandRepository.findAll(PageRequest.of(page, size, Sort.by(sortBy))).getContent();

        log.atInfo().log("Returning List<Brand> Data");
        return this.brandDTOMapperService.BrandToBrandGetAllResponse(brands);
    }
}
