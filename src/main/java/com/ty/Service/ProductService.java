package com.ty.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ty.Reposetory.ProductRepo;
import com.ty.entity.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepository;

	// Get all categories with pagination
	public Iterable<Product> getAllCategories(int page) {
		return productRepository.findAll(PageRequest.of(page, 10)); // Page size of 10
	}

	// Create a new Product
	public Product createProduct(Product Product) {
		return productRepository.save(Product);
	}

	// Get Product by ID
	public Optional<Product> getProductById(Integer id) {
		return productRepository.findById(id);
	}

	// Update Product by ID
	public Object updateProduct(Integer id, Product Product) {
		Optional<Product> existingProduct = productRepository.findById(id);
		if (existingProduct.isPresent()) {
			Product.setId(id); // Preserve the ID
			return productRepository.save(Product);
		}
		return null;
	}

	// Delete Product by ID
	public boolean deleteProduct(Integer id) {
		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
			return true;
		}
		return false;
	}
}