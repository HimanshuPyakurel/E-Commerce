package com.springproject.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.ecommerce.model.Category;
import com.springproject.ecommerce.repository.CategoryRepository;
import com.springproject.ecommerce.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository catRepo;

	@Override
	public void addCategory(Category category) {
		catRepo.save(category);
	}	

	@Override
	public void deleteCategory(long id) {
		catRepo.deleteById(id);
	}

	@Override
	public void updateCategory(Category category) {
		catRepo.save(category);
	}

	@Override
	public Category getCategoryById(long id) {
		
		return catRepo.findById(id).get();
	}
	
	@Override
	public List<Category> getAllCategory() {
		
		return catRepo.findAll();
	}
	
	
}
