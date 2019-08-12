package com.epam.rd.spring2019.pet.validators;

import com.epam.rd.spring2019.pet.exceptions.ValidationException;
import com.epam.rd.spring2019.pet.web.dtos.FilterProductDto;
import com.epam.rd.spring2019.pet.web.dtos.ProductCreateDto;

public class ProductValidatorImpl implements ProductValidator{

    @Override
    public void validateNewProduct(ProductCreateDto createDto) {
        if (createDto.getName() == null || createDto.getName().isEmpty()) {
            throw new ValidationException("Field name mustn't be empty!");
        }

        if (createDto.getVolume() != null && createDto.getVolume() < 0) {
            throw new ValidationException("Volume mustn't be negative!");
        }

        if (createDto.getWeight() != null && createDto.getWeight() < 0) {
            throw new ValidationException("Weight mustn't be negative!");
        }

        if (createDto.getPrice() != null && createDto.getPrice() < 0) {
            throw new ValidationException("Price mustn't be negative!");
        }
    }

    @Override
    public void validateFilterProduct(FilterProductDto filterProductDto) {
        Integer minPrice = null;
        Integer maxPrice = null;
        if (filterProductDto.getMinPrice() != null) {
            try {
                 minPrice = Integer.valueOf(filterProductDto.getMinPrice());
                 if (minPrice < 0) {
                     throw new ValidationException("Min price musn't be negative number!");
                 }
            } catch (IllegalArgumentException ex) {
                throw new ValidationException("Min price isn't number!");
            }
        }

        if (filterProductDto.getMaxPrice() != null) {
            try {
                maxPrice = Integer.valueOf(filterProductDto.getMaxPrice());
                if (maxPrice < 0) {
                    throw new ValidationException("Max price musn't be negative number!");
                }
            } catch (IllegalArgumentException ex) {
                throw new ValidationException("Max price isn't number!");
            }
        }

        if (minPrice != null && maxPrice != null && maxPrice > 0 && minPrice > maxPrice) {
            throw new ValidationException("Min price can't be more then max price!");
        }

        //TODO: validate array list of productId
    }
}
