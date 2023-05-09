package com.recap.carrental.business.abstracts;

import com.recap.carrental.business.requests.customerRequests.CustomerCreateRequest;
import com.recap.carrental.business.requests.customerRequests.CustomerUpdateRequest;
import com.recap.carrental.business.responses.customerResponses.CustomerGetAllResponse;
import com.recap.carrental.business.responses.customerResponses.CustomerGetByIdResponse;

import java.util.List;

public interface CustomerService {
    String create(CustomerCreateRequest request);
    String update(int id, CustomerUpdateRequest request);
    String delete(int id);
    CustomerGetByIdResponse getById(int id);
    List<CustomerGetAllResponse> getAll();
}
