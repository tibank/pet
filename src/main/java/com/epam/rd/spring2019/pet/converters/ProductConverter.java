package com.epam.rd.spring2019.pet.converters;

import com.epam.rd.spring2019.pet.daos.CategoryDao;
import com.epam.rd.spring2019.pet.daos.CategoryDaoImpl;
import com.epam.rd.spring2019.pet.models.Category;
import com.epam.rd.spring2019.pet.models.Product;
import com.epam.rd.spring2019.pet.web.dtos.ProductCreateDto;
import com.epam.rd.spring2019.pet.web.dtos.ProductViewDto;

public class ProductConverter {
    private CategoryDao categoryDao = new CategoryDaoImpl();

    public Product asProduct(ProductCreateDto productCreateDto) {
        Category category = categoryDao.getCategoryById(productCreateDto.getCategoryId());
        return new Product.Builder()
                .setName(productCreateDto.getName())
                .setDescription(productCreateDto.getDescription())
                .setImage(productCreateDto.getImage())
                .setWeight(productCreateDto.getWeight())
                .setVolume(productCreateDto.getVolume())
                .setPrice(productCreateDto.getPrice())
                .setCategory(category)
                .build();
    }

    public ProductViewDto asProductDto(Product product) {
        ProductViewDto productViewDto = new ProductViewDto();

        productViewDto.setId(product.getId());
        productViewDto.setName(product.getName());
        productViewDto.setDescription(product.getDescription());
        productViewDto.setImage(product.getImage());
        productViewDto.setVolume(product.getVolume());
        productViewDto.setWeight(product.getWeight());
        productViewDto.setPrice(product.getPrice());
        productViewDto.setCategory(product.getCategory().getName());

        return productViewDto;
    }
}
