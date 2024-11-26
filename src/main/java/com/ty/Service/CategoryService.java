package com.ty.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ty.Reposetory.CategoryRepository;
import com.ty.entity.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	// Get all categories with pagination
	public Iterable<Category> getAllCategories(int page) {
		return categoryRepository.findAll(PageRequest.of(page, 10)); // Page size of 10
	}

	// Create a new category
	public Category createCategory(Category category) {
		return (Category) categoryRepository.save(category);
	}

	// Get category by ID
	public Optional<Category> getCategoryById(Long id) {
		return categoryRepository.findById(id);
	}

	// Update category by ID
	public Object updateCategory(Long id, Category category) {
		Optional<Category> existingCategory = categoryRepository.findById(id);
		if (existingCategory.isPresent()) {
			category.setId(id); // Preserve the ID
			return categoryRepository.save(category);
		}
		return null;
	}

	// Delete category by ID
	public boolean deleteCategory(Long id) {
		if (categoryRepository.existsById(id)) {
			categoryRepository.deleteById(id);
			return true;
		}
		return false;
	}
}