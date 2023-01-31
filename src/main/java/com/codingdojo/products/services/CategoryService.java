package com.codingdojo.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;
import com.codingdojo.products.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepo;
	
	public Category save(Category category) {
		return categoryRepo.save(category);
	}
	
	public Category update(Category category) {
		return categoryRepo.save(category);
	}
	
	
	public Category findCategoryById(Long id) {
		Optional<Category> category = categoryRepo.findById(id);
		if(category.isEmpty()) {
			return null;
		}
		return category.get();
	}
	
	public Category addProduct(Product product, Long categoryId) {
	    
	    // retrieve an instance of a category using another method in the service.
	    Category thisCategory = findCategoryById(categoryId);
	    
	    // retrieve an instance of a product using another method in the service
	    
	    // add the product to this category's list of products
	    thisCategory.getProducts().add(product);
	    
	    // Save thisCategory, since you made changes to its product list.
	    return categoryRepo.save(thisCategory);	


		
	}
	public List<Category> categoriesByProduct(Product product){
		
		return categoryRepo.findAllByProducts(product);
	}
	
	public List<Category> categoriesByNotProduct(Product product){
		
		return categoryRepo.findByProductsNotContains(product);
	}
	
	public List<Category> getAll(){
		return categoryRepo.findAll();
	}
	
	

}
