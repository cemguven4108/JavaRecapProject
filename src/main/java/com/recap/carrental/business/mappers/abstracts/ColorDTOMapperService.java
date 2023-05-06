package com.recap.carrental.business.mappers.abstracts;

import com.recap.carrental.business.requests.colorRequests.ColorCreateRequest;
import com.recap.carrental.business.responses.colorResponses.ColorGetByIdResponse;
import com.recap.carrental.entities.Color;

public interface ColorDTOMapperService {

    Color ColorCreateRequestToColor(ColorCreateRequest request);
    ColorGetByIdResponse ColorToColorGetByIdResponse(Color color);
    Color ColorGetByIdResponseToColor(ColorGetByIdResponse response);
}
