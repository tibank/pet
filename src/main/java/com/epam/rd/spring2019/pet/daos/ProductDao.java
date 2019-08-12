package com.epam.rd.spring2019.pet.daos;


import com.epam.rd.spring2019.pet.models.Product;
import com.epam.rd.spring2019.pet.web.dtos.FilterProductDto;

import java.util.List;

public interface ProductDao {

    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product addProduct(Product product);
    List<Product> getProductsByFilter(FilterProductDto filter);
}
