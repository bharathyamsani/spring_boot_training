package com.example.pcspringboot.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pcspringboot.Repository.CategoryRepository;
import com.example.pcspringboot.Repository.ProductRepository;
import com.example.pcspringboot.model.Category;
import com.example.pcspringboot.model.Product;
import com.example.pcspringboot.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Product addProduct(Product p) {
		Category pc = categoryRepository.findById(p.getCategory().getCategoryId()).get();
		p.setCategory(pc);
		return productRepository.save(p);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(long id) {
		return productRepository.findById(id).get();
	}

	@Override
	public Product updateProduct(long id, Product p) {
		Product pp = getProduct(id);
		pp.setProductName(p.getProductName());
		Category pc = categoryRepository.findById(p.getCategory().getCategoryId()).get();
		pp.setCategory(pc);
		pp.setProductPrice(p.getProductPrice());
		return productRepository.save(pp);
	}

	@Override
	public void deleteProduct(long id) {
		productRepository.deleteById(id);
		return;
	}

}
