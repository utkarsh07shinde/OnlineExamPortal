package com.OnlineExamPortal.services;

import java.util.List;

import com.OnlineExamPortal.entity.Category;

public interface categoryService {

	Category addCategory(Category category);

    List<Category> getCategories();

    Category getCategory(Long catId);

    Category updateCategory(Category category);

    void deleteCategory(Long categoryId);

}
