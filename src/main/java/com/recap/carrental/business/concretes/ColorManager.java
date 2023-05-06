package com.recap.carrental.business.concretes;

import com.recap.carrental.business.abstracts.ColorService;
import com.recap.carrental.business.mappers.abstracts.ColorDTOMapperService;
import com.recap.carrental.business.requests.colorRequests.ColorCreateRequest;
import com.recap.carrental.business.responses.colorResponses.ColorGetByIdResponse;
import com.recap.carrental.dataAccess.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ColorManager implements ColorService {

    private final ColorRepository colorRepository;
    private final ColorDTOMapperService colorDTOMapperService;

    @Override
    public String create(ColorCreateRequest request) {
        this.colorRepository.save(this.colorDTOMapperService.ColorCreateRequestToColor(request));
        return this.colorRepository.existsByColorName(request.colorName()) ? "Success" : "Failed";
    }

    @Override
    public ColorGetByIdResponse getById(int colorId) {
        return this.colorDTOMapperService.ColorToColorGetByIdResponse(
                this.colorRepository.findById(colorId).orElseThrow());
    }
}
