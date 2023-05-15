package com.recap.carrental.business.mappers.concretes;

import com.recap.carrental.business.mappers.abstracts.CustomerDTOMapperService;
import com.recap.carrental.business.requests.customerRequests.CustomerCreateRequest;
import com.recap.carrental.business.requests.customerRequests.CustomerUpdateRequest;
import com.recap.carrental.business.responses.customerResponses.CustomerGetAllResponse;
import com.recap.carrental.business.responses.customerResponses.CustomerGetByIdResponse;
import com.recap.carrental.core.business.abstracts.UserService;
import com.recap.carrental.entities.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerDTOMapperManager implements CustomerDTOMapperService {

    private final UserService userService;

    @Override
    public Customer CustomerCreateRequestToCustomer(CustomerCreateRequest request) {
        Customer customer = new Customer();
        customer.setCompanyName(request.companyName());
        customer.setUser(this.userService.getById(request.userId()));

        return customer;
    }

    @Override
    public Customer CustomerUpdateRequestToCustomer(int id, CustomerUpdateRequest request) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setCompanyName(request.companyName());
        customer.setUser(this.userService.getById(request.userId()));

        return customer;
    }

    @Override
    public CustomerGetByIdResponse CustomerToCustomerGetByIdResponse(Customer customer) {

        return new CustomerGetByIdResponse(
                customer.getId(),
                customer.getCompanyName(),
                customer.getUser().getFirstName(),
                customer.getUser().getLastName(),
                customer.getUser().getEmail(),
                customer.getUser().getPassword()
        );
    }

    @Override
    public List<CustomerGetAllResponse> CustomerToCustomerGetAllResponse(List<Customer> customers) {
        List<CustomerGetAllResponse> responses = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerGetAllResponse response = new CustomerGetAllResponse(
                    customer.getId(),
                    customer.getCompanyName(),
                    customer.getUser().getFirstName(),
                    customer.getUser().getLastName(),
                    customer.getUser().getEmail(),
                    customer.getUser().getPassword()
            );
            responses.add(response);
        }
        return responses;
    }


    // -------------------- REVERSE MAPPING ------------------ \\


    @Override
    public Customer CustomerGetByIdResponseToCustomer(int customerId) {
        Customer customer = new Customer();
        customer.setId(customerId);

        return customer;
    }
}
