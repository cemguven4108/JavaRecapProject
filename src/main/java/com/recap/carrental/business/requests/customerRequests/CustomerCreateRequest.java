package com.recap.carrental.business.requests.customerRequests;

public record CustomerCreateRequest(
        String companyName,
        int userId
) {}
