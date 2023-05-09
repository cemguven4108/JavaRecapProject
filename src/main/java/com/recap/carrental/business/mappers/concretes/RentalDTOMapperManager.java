package com.recap.carrental.business.mappers.concretes;

import com.recap.carrental.business.mappers.abstracts.CarDTOMapperService;
import com.recap.carrental.business.mappers.abstracts.CustomerDTOMapperService;
import com.recap.carrental.business.mappers.abstracts.RentalDTOMapperService;
import com.recap.carrental.business.requests.rentalRequests.RentalCreateRequest;
import com.recap.carrental.business.requests.rentalRequests.RentalUpdateRequest;
import com.recap.carrental.business.responses.rentalResponses.RentalGetAllResponse;
import com.recap.carrental.business.responses.rentalResponses.RentalGetByIdResponse;
import com.recap.carrental.entities.Rental;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentalDTOMapperManager implements RentalDTOMapperService {

    private final CustomerDTOMapperService customerDTOMapperService;
    private final CarDTOMapperService carDTOMapperService;

    @Override
    public Rental RentalCreateRequestToRental(RentalCreateRequest request) {
        Rental rental = new Rental();
        rental.setRentDate(request.rentDate());
        rental.setCar(this.carDTOMapperService.CarGetByIdResponseToCar(request.carId()));
        rental.setCustomer(this.customerDTOMapperService.CustomerGetByIdResponseToCustomer(request.customerId()));

        return rental;
    }

    @Override
    public Rental RentalUpdateRequestToRental(int id, RentalUpdateRequest request) {
        Rental rental = new Rental();
        rental.setId(id);
        rental.setRentDate(request.rentDate());
        rental.setCar(this.carDTOMapperService.CarGetByIdResponseToCar(request.carId()));
        rental.setCustomer(this.customerDTOMapperService.CustomerGetByIdResponseToCustomer(request.customerId()));

        return rental;
    }

    @Override
    public RentalGetByIdResponse RentalToRentalGetByIdResponse(Rental rental) {
        return new RentalGetByIdResponse(
                rental.getId(),
                rental.getRentDate(),
                rental.getReturnDate(),
                rental.getCar().getId(),
                rental.getCustomer().getUser().getFirstName(),
                rental.getCustomer().getUser().getLastName()
        );
    }

    @Override
    public List<RentalGetAllResponse> RentalToRentalGetAllResponse(List<Rental> rentals) {
        return rentals.stream()
                .map(rental -> new RentalGetAllResponse(
                        rental.getId(),
                        rental.getRentDate(),
                        rental.getReturnDate(),
                        rental.getCar().getId(),
                        rental.getCustomer().getUser().getFirstName(),
                        rental.getCustomer().getUser().getLastName()
                )).collect(Collectors.toList());
    }


    // -------------------- REVERSE MAPPING ------------------ \\
}
