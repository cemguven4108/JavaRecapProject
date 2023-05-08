package com.recap.carrental.business.mappers.concretes;

import com.recap.carrental.business.abstracts.ColorService;
import com.recap.carrental.business.mappers.abstracts.ColorDTOMapperService;
import com.recap.carrental.business.requests.colorRequests.ColorCreateRequest;
import com.recap.carrental.business.requests.colorRequests.ColorUpdateRequest;
import com.recap.carrental.business.responses.colorResponses.ColorGetAllResponse;
import com.recap.carrental.business.responses.colorResponses.ColorGetByIdResponse;
import com.recap.carrental.entities.Color;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public Color ColorUpdateRequestToColor(int id, ColorUpdateRequest request) {
        Color color = new Color();
        color.setId(id);
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
    public List<ColorGetAllResponse> ColorToColorGetAllResponse(List<Color> colors) {
        return colors.stream()
                .map(color -> new ColorGetAllResponse(
                        color.getId(),
                        color.getColorName()
                )).collect(Collectors.toList());
    }


    // -------------------- REVERSE MAPPING ------------------ \\

    @Override
    public Color ColorGetByIdResponseToColor(int colorId) {
        Color color = new Color();
        color.setId(colorId);
        return color;
    }
}
