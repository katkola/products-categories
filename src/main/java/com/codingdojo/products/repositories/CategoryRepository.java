package com.codingdojo.products.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	public List<Category> findAll();
	
	Optional<Category> findByName(String name);
	
    // Retrieves a list of all categories for a particular product
    List<Category> findAllByProducts(Product product);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Category> findByProductsNotContains(Product product);

}
