package com.recap.carrental.business.rules;

import com.recap.carrental.core.utilities.exceptions.runtimeExceptions.DuplicateNameException;
import com.recap.carrental.core.utilities.exceptions.runtimeExceptions.MaxNameLengthViolationException;
import com.recap.carrental.core.utilities.exceptions.runtimeExceptions.MinNameLengthViolationException;
import com.recap.carrental.dataAccess.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandBusinessRules {
    final int MIN_NAME_LENGTH = 3;
    final int MAX_NAME_LENGTH = 41;

    private final BrandRepository brandRepository;

    public void checkIfBrandNameExists(String brandName) {
        if (this.brandRepository.existsByBrandName(brandName)) {
            throw new DuplicateNameException("BrandName Already Exists");
        }
    }

    public void checkIfBrandNameLengthIsValid(String brandName) {
        if (brandName.length() < MIN_NAME_LENGTH) {
            throw new MinNameLengthViolationException(String.format("Min BrandName Length is %s", MIN_NAME_LENGTH));
        }
        else if (brandName.length() > MAX_NAME_LENGTH) {
            throw new MaxNameLengthViolationException(String.format("Max BrandName Length is %s", MAX_NAME_LENGTH));
        }
    }
}
