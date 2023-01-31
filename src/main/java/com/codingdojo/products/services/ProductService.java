package com.codingdojo.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;
import com.codingdojo.products.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
		
	public Product findProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		
		if(product.isEmpty()) {
			return null;
		}
		return product.get();
	}
	
	public Product addCategory(Category thisCategory, Product thisProduct) {
	    
	    // This has the same effect as above:
	    thisProduct.getCategories().add(thisCategory);	// add the category to this products's list of categories
	    productRepository.save(thisProduct);	// Save thisProduct, since you made changes to its category list.
	    
	    return thisProduct;
	}
	
	public Product save(Product product) {
		
		return productRepository.save(product);
	}
	
	public Product update(Product product) {
		
		return productRepository.save(product);
	}
	public List<Product> productsByCategory(Category category){
		
		return productRepository.findAllByCategories(category);
	}
	
	public List<Product> productsByNotCategory(Category category){
		
		return productRepository.findByCategoriesNotContains(category);
	}
	
	
	public List<Product> getAll(){
		return productRepository.findAll();
	}
}
