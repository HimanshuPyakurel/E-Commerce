package com.springproject.ecommerce.service;

import java.util.List;
import com.springproject.ecommerce.model.Category;

public interface CategoryService {

	void addCategory(Category category);
	
	void deleteCategory(long id);

	void updateCategory(Category category);
	
	Category getCategoryById(long id);
	
	List<Category> getAllCategory();
	

	

}
