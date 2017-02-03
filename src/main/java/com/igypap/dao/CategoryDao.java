package com.igypap.dao;

import com.igypap.model.Category;

import java.util.List;

/**
 * Created by igypap on 03.02.17.
 */
public interface CategoryDao {

    void addCategory(Category category);

    public List<Category> getAllCategories();

    Category findById(int id);

}
