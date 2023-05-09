package com.recap.carrental.business.requests.customerRequests;

public record CustomerUpdateRequest(
        String companyName,
        int userId
) {}
