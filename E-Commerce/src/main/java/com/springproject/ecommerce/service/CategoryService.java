package com.springproject.ecommerce.service;

import java.util.List;
import com.springproject.ecommerce.model.Category;

public interface CategoryService {

	void addCategory(Category category);
	
	void deleteCategory(int id);

	void updateCategory(Category category);
	
	Category getCategoryById(int id);
	
	List<Category> getAllCategory();
	

}
