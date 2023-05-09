package com.recap.carrental.business.concretes;

import com.recap.carrental.business.abstracts.RentalService;
import com.recap.carrental.business.mappers.abstracts.RentalDTOMapperService;
import com.recap.carrental.business.requests.rentalRequests.RentalCreateRequest;
import com.recap.carrental.business.requests.rentalRequests.RentalUpdateRequest;
import com.recap.carrental.business.responses.rentalResponses.RentalGetAllResponse;
import com.recap.carrental.business.responses.rentalResponses.RentalGetByIdResponse;
import com.recap.carrental.dataAccess.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalManager implements RentalService {

    private final RentalRepository rentalRepository;
    private final RentalDTOMapperService rentalDTOMapperService;

    @Override
    public String create(RentalCreateRequest request) {

        if (this.rentalRepository.existsByCarIdAndReturnDateIsNull(request.carId())) {
            return "Failed Because this car is already rented";
        }

        this.rentalRepository.save(this.rentalDTOMapperService.RentalCreateRequestToRental(request));
        return this.rentalRepository.existsByCarIdAndReturnDateIsNull(request.carId()) ? "Success" : "Failed";
    }

    @Override
    public String update(int id, RentalUpdateRequest request) {
        this.rentalRepository.save(this.rentalDTOMapperService.RentalUpdateRequestToRental(id, request));
        return "Success";
    }

    @Override
    public String delete(int id) {
        this.rentalRepository.deleteById(id);
        return this.rentalRepository.findById(id).isEmpty() ? "Success" : "Failed";
    }

    @Override
    public RentalGetByIdResponse getById(int id) {
        return this.rentalDTOMapperService.RentalToRentalGetByIdResponse(
                this.rentalRepository.findById(id).orElseThrow()
        );
    }

    @Override
    public List<RentalGetAllResponse> getAll() {
        return this.rentalDTOMapperService.RentalToRentalGetAllResponse(
                this.rentalRepository.findAll()
        );
    }
}
