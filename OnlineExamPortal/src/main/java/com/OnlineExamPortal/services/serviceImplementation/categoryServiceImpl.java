package com.OnlineExamPortal.services.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineExamPortal.entity.Category;
import com.OnlineExamPortal.repository.categoryRepository;
import com.OnlineExamPortal.services.categoryService;

@Service
public class categoryServiceImpl implements categoryService {

	@Autowired
	private categoryRepository categoryRepository;
	 @Override
	    public Category addCategory(Category category) {
	        return categoryRepository.save(category);
	    }

	    @Override
	    public List<Category> getCategories() {
	        return categoryRepository.findAll();
	    }

	    @Override
	    public Category getCategory(Long catId) {
	        Optional<Category> optionalCategory = categoryRepository.findById(catId);
	        return optionalCategory.orElse(null);
	    }

	    @Override
	    public Category updateCategory(Category category) {
	        return categoryRepository.save(category);
	    }

	    @Override
	    public void deleteCategory(Long categoryId) {
	        categoryRepository.deleteById(categoryId);
	    }

}
