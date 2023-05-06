package com.recap.carrental.business.mappers.concretes;

import com.recap.carrental.business.abstracts.ColorService;
import com.recap.carrental.business.mappers.abstracts.ColorDTOMapperService;
import com.recap.carrental.business.requests.colorRequests.ColorCreateRequest;
import com.recap.carrental.business.responses.colorResponses.ColorGetByIdResponse;
import com.recap.carrental.entities.Color;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ColorDTOMapperManager implements ColorDTOMapperService {

    @Override
    public Color ColorCreateRequestToColor(ColorCreateRequest request) {

        Color color = new Color();
        color.setColorName(request.colorName());

        return color;
    }

    @Override
    public ColorGetByIdResponse ColorToColorGetByIdResponse(Color color) {
        return new ColorGetByIdResponse(
                color.getId(),
                color.getColorName()
        );
    }

    @Override
    public Color ColorGetByIdResponseToColor(ColorGetByIdResponse response) {
        Color color = new Color();
        color.setId(response.id());
        return color;
    }
}
