package com.epam.rd.spring2019.pet.services;

import com.epam.rd.spring2019.pet.web.dtos.FilterProductDto;
import com.epam.rd.spring2019.pet.web.dtos.ProductCreateDto;
import com.epam.rd.spring2019.pet.web.dtos.ProductViewDto;

import java.util.List;

public interface ProductService {

    ProductViewDto addNewProduct(ProductCreateDto createDto);
    List<ProductViewDto> getAllProducts();
    ProductViewDto getProductById(Long id);
    List<ProductViewDto> getProductsByFilter(FilterProductDto filterProductDto);
}
