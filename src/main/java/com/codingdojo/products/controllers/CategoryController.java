package com.codingdojo.products.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;
import com.codingdojo.products.services.CategoryService;
import com.codingdojo.products.services.ProductService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryServ;
	@Autowired
	ProductService productServ;
	
	@GetMapping("/{category_id}")
	public String categoryPage(Model model, @PathVariable("category_id")Long category_id) {
		
		Category category = categoryServ.findCategoryById(category_id);
		model.addAttribute("category", category);

		List<Product> allProducts = productServ.productsByNotCategory(category);
		model.addAttribute("allProducts", allProducts);
		
		return "showCategory.jsp";
	}
	
	@GetMapping("/new")
	public String categoryForm(Model model) {
		
		Category category = new Category();
		model.addAttribute("category", category);
		
		return "newCategory.jsp";
	}
	
	@PostMapping("/create")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		
		if(result.hasErrors()) {
			return "newCategory.jsp";
		}
		categoryServ.save(category);
		return "redirect:/";
	}
	
	@PostMapping("/update/{categoryId}")
	public String updateCategory(@PathVariable("categoryId") Long categoryId, @RequestParam(value="productId") Long productId, Model model) {
		Product product = productServ.findProductById(productId);
		Category category = categoryServ.findCategoryById(categoryId);
		
		product.getCategories().add(category);
		productServ.update(product);
		
		return "redirect:/categories/"+ categoryId;
	}
	
	
	
	@GetMapping("/{id}/delete")
	public String deleteCategory(@PathVariable("id") Long id) {
		Category category = categoryServ.findCategoryById(id);
		for(Product product: category.getProducts()) {
			product.getCategories().remove(category);
			productServ.save(product);
		}
		
		return "index.jsp";
	}
	
}
