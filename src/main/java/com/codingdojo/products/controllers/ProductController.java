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
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productServ;
	
	@Autowired
	private CategoryService categoryServ;
	
	@GetMapping("/{product_id}")
	public String productPage(Model model, @PathVariable("product_id")Long product_id) {
		
		Product product = productServ.findProductById(product_id);
		model.addAttribute("product", product);

		List<Category> allCategories = categoryServ.categoriesByNotProduct(product);
		model.addAttribute("allCategories", allCategories);
		
		return "showProduct.jsp";
	}
	
	@GetMapping("/new")
	public String productForm(Model model) {
		
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "newProduct.jsp";
	}
	
	@PostMapping("/create")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		
		if(result.hasErrors()) {
			return "newProduct.jsp";
		}
		productServ.save(product);
		return "redirect:/";
	}
	
	@PostMapping("/update/{productId}")
	public String updateProduct(@PathVariable("productId") Long productId, @RequestParam(value="categoryId") Long categoryId, Model model) {
		Product product = productServ.findProductById(productId);
		Category category = categoryServ.findCategoryById(categoryId);
		
		product.getCategories().add(category);
		productServ.update(product);
		
		return "redirect:/products/"+ productId;
	}
}
