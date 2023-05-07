package com.recap.carrental.business.mappers.abstracts;

import com.recap.carrental.business.requests.colorRequests.ColorCreateRequest;
import com.recap.carrental.business.requests.colorRequests.ColorUpdateRequest;
import com.recap.carrental.business.responses.colorResponses.ColorGetAllResponse;
import com.recap.carrental.business.responses.colorResponses.ColorGetByIdResponse;
import com.recap.carrental.entities.Color;

import java.util.List;

public interface ColorDTOMapperService {

    Color ColorCreateRequestToColor(ColorCreateRequest request);


    Color ColorUpdateRequestToColor(int id, ColorUpdateRequest request);


    ColorGetByIdResponse ColorToColorGetByIdResponse(Color color);
    Color ColorGetByIdResponseToColor(ColorGetByIdResponse response);

    List<ColorGetAllResponse> ColorToColorGetAllResponse(List<Color> colors);
}
