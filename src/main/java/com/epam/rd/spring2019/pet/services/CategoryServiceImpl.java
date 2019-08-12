package com.epam.rd.spring2019.pet.services;

import com.epam.rd.spring2019.pet.daos.CategoryDao;
import com.epam.rd.spring2019.pet.daos.CategoryDaoImpl;
import com.epam.rd.spring2019.pet.models.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Override
    public List<Category> getAllCategories() {
        CategoryDao categoryDao = new CategoryDaoImpl();

        return categoryDao.getAllCategories();
    }
}
