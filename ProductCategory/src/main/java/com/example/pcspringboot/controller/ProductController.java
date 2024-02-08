package com.example.pcspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pcspringboot.dto.ProductDto;
import com.example.pcspringboot.model.Product;
import com.example.pcspringboot.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@GetMapping
	public List<ProductDto> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("{id}")
	public ProductDto getProduct(@PathVariable long id) {
		return productService.getProduct(id);
	}

	@PutMapping("{id}")
	public Product updateProduct(@PathVariable long id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}

	@DeleteMapping("{id}")
	public String deleteProduct(@PathVariable long id) {
		productService.deleteProduct(id);
		return "Record Deleted Successfully";
	}

}
