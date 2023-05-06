package com.recap.carrental.business.abstracts;

import com.recap.carrental.business.requests.colorRequests.ColorCreateRequest;
import com.recap.carrental.business.responses.colorResponses.ColorGetByIdResponse;

public interface ColorService {
    String create(ColorCreateRequest colorCreateRequest);
    ColorGetByIdResponse getById(int colorId);
}
