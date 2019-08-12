package com.epam.rd.spring2019.pet.services;

import com.epam.rd.spring2019.pet.converters.ProductConverter;
import com.epam.rd.spring2019.pet.daos.ProductDao;
import com.epam.rd.spring2019.pet.daos.ProductDaoImpl;
import com.epam.rd.spring2019.pet.models.Product;
import com.epam.rd.spring2019.pet.validators.ProductValidator;
import com.epam.rd.spring2019.pet.validators.ProductValidatorImpl;
import com.epam.rd.spring2019.pet.web.dtos.FilterProductDto;
import com.epam.rd.spring2019.pet.web.dtos.ProductCreateDto;
import com.epam.rd.spring2019.pet.web.dtos.ProductViewDto;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoImpl();
    private ProductValidator productValidator = new ProductValidatorImpl();
    private ProductConverter productConverter = new ProductConverter();

    @Override
    public ProductViewDto addNewProduct(ProductCreateDto createDto) {
        productValidator.validateNewProduct(createDto);
        Product product = productConverter.asProduct(createDto);
        product = productDao.addProduct(product);

        return product != null ? productConverter.asProductDto(product) : null;
    }

    @Override
    public List<ProductViewDto> getAllProducts() {
        List<ProductViewDto> productViewDtoList = new ArrayList<>();
        List<Product> productList = productDao.getAllProducts();

        for (Product product: productList) {
            productViewDtoList.add(productConverter.asProductDto(product));
        }

        return productViewDtoList;
    }

    @Override
    public ProductViewDto getProductById(Long id) {
        Product product = productDao.getProductById(id);
        return product != null
                ? productConverter.asProductDto(product)
                : null;

    }

    @Override
    public List<ProductViewDto> getProductsByFilter(FilterProductDto filterProductDto) {
        List<Product> productList = new ArrayList<>();
        List<ProductViewDto> productViewDtoList = new ArrayList<>();

        productValidator.validateFilterProduct(filterProductDto);
        productList = productDao.getProductsByFilter(filterProductDto);

        if (productList.size() > 0) {
            for (Product product: productList) {
                productViewDtoList.add(productConverter.asProductDto(product));
            }
        }

        return productViewDtoList;
    }
}
