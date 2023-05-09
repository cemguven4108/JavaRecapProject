package com.recap.carrental.business.mappers.abstracts;

import com.recap.carrental.business.requests.rentalRequests.RentalCreateRequest;
import com.recap.carrental.business.requests.rentalRequests.RentalUpdateRequest;
import com.recap.carrental.business.responses.rentalResponses.RentalGetAllResponse;
import com.recap.carrental.business.responses.rentalResponses.RentalGetByIdResponse;
import com.recap.carrental.entities.Rental;

import java.util.List;

public interface RentalDTOMapperService {
    Rental RentalCreateRequestToRental(RentalCreateRequest request);

    Rental RentalUpdateRequestToRental(int id, RentalUpdateRequest request);

    RentalGetByIdResponse RentalToRentalGetByIdResponse(Rental rental);

    List<RentalGetAllResponse> RentalToRentalGetAllResponse(List<Rental> rentals);


    // -------------------- REVERSE MAPPING ------------------ \\
}
