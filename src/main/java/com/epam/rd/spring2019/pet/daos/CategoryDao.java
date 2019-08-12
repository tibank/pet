package com.epam.rd.spring2019.pet.daos;

import com.epam.rd.spring2019.pet.models.Category;

import java.util.List;

public interface CategoryDao {
    Category getCategoryById(Integer id);
    List<Category> getAllCategories();
}
