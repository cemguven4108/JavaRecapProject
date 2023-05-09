package com.recap.carrental.business.concretes;

import com.recap.carrental.business.abstracts.CustomerService;
import com.recap.carrental.business.mappers.abstracts.CustomerDTOMapperService;
import com.recap.carrental.business.requests.customerRequests.CustomerCreateRequest;
import com.recap.carrental.business.requests.customerRequests.CustomerUpdateRequest;
import com.recap.carrental.business.responses.customerResponses.CustomerGetAllResponse;
import com.recap.carrental.business.responses.customerResponses.CustomerGetByIdResponse;
import com.recap.carrental.dataAccess.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerManager implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDTOMapperService customerDTOMapperService;

    @Override
    public String create(CustomerCreateRequest request) {
        this.customerRepository.save(this.customerDTOMapperService.CustomerCreateRequestToCustomer(request));
        return this.customerRepository.existsByCompanyName(request.companyName()) ? "Success" : "Failed";
    }

    @Override
    public String update(int id, CustomerUpdateRequest request) {
        this.customerRepository.save(this.customerDTOMapperService.CustomerUpdateRequestToCustomer(id, request));
        return "Success";
    }

    @Override
    public String delete(int id) {
        this.customerRepository.deleteById(id);
        return this.customerRepository.findById(id).isEmpty() ? "Success" : "Failed";
    }

    @Override
    public CustomerGetByIdResponse getById(int id) {
        return this.customerDTOMapperService.CustomerToCustomerGetByIdResponse(
                this.customerRepository.findById(id).orElseThrow()
        );
    }

    @Override
    public List<CustomerGetAllResponse> getAll() {
        return this.customerDTOMapperService.CustomerToCustomerGetAllResponse(
                this.customerRepository.findAll()
        );
    }
}
