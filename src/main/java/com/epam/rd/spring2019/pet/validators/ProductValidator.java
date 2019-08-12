package com.epam.rd.spring2019.pet.validators;

import com.epam.rd.spring2019.pet.web.dtos.FilterProductDto;
import com.epam.rd.spring2019.pet.web.dtos.ProductCreateDto;

public interface ProductValidator {

    void validateNewProduct(ProductCreateDto createDto);
    void validateFilterProduct(FilterProductDto filterProductDto);
}
