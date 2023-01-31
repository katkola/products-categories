package com.codingdojo.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;
import com.codingdojo.products.services.CategoryService;
import com.codingdojo.products.services.ProductService;

@Controller
public class HomeConroller {
	
	@Autowired
	private ProductService productServ;
	
	@Autowired
	private CategoryService categoryServ;
	
	
	@GetMapping("/")
	public String index(Model model) {
		
		List<Product> allProducts = productServ.getAll();
		model.addAttribute("allProducts", allProducts);
		
		List<Category> allCategories = categoryServ.getAll();
		model.addAttribute("allCategories", allCategories);
		
		return "index.jsp";
	}
}
