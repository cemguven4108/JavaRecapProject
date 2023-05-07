package com.recap.carrental.business.abstracts;

import com.recap.carrental.business.requests.colorRequests.ColorCreateRequest;
import com.recap.carrental.business.requests.colorRequests.ColorUpdateRequest;
import com.recap.carrental.business.responses.colorResponses.ColorGetAllResponse;
import com.recap.carrental.business.responses.colorResponses.ColorGetByIdResponse;

import java.util.List;

public interface ColorService {
    String create(ColorCreateRequest request);
    String update(int id, ColorUpdateRequest request);
    String delete(int id);
    ColorGetByIdResponse getById(int colorId);
    List<ColorGetAllResponse> getAll();
}
