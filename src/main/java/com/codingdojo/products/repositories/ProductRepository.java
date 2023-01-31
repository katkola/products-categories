package com.codingdojo.products.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	
	public List<Product> findAll();
	
	Optional<Product> findByName(String name);
	
	List<Product> findAllByCategories(Category category);
	
	List<Product> findByCategoriesNotContains(Category category);
}
