package com.recap.carrental.business.mappers.abstracts;

import com.recap.carrental.business.requests.customerRequests.CustomerCreateRequest;
import com.recap.carrental.business.requests.customerRequests.CustomerUpdateRequest;
import com.recap.carrental.business.responses.customerResponses.CustomerGetAllResponse;
import com.recap.carrental.business.responses.customerResponses.CustomerGetByIdResponse;
import com.recap.carrental.entities.Customer;

import java.util.List;

public interface CustomerDTOMapperService {
    Customer CustomerCreateRequestToCustomer(CustomerCreateRequest request);

    Customer CustomerUpdateRequestToCustomer(int id, CustomerUpdateRequest request);

    CustomerGetByIdResponse CustomerToCustomerGetByIdResponse(Customer customer);

    List<CustomerGetAllResponse> CustomerToCustomerGetAllResponse(List<Customer> customers);


    // -------------------- REVERSE MAPPING ------------------ \\

    Customer CustomerGetByIdResponseToCustomer(int customerId);
}
