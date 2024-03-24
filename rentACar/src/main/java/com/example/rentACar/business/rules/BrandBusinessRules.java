package com.example.rentACar.business.rules;

import com.example.rentACar.core.utilities.exceptions.BusinessException;
import com.example.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {

    private BrandRepository brandRepository;

    public void checkIfBrandNameExists(String name) {
        if (brandRepository.existsByName(name)) {
            throw new BusinessException("Brand name already exists"); // Java exception types
        }

    }


}
