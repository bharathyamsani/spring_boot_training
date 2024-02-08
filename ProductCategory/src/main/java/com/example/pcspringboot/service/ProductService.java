package com.example.pcspringboot.service;

import java.util.List;

import com.example.pcspringboot.dto.ProductDto;
import com.example.pcspringboot.model.Product;

public interface ProductService {

	Product addProduct(Product p);

	List<ProductDto> getAllProducts();

	ProductDto getProduct(long id);

	Product updateProduct(long id, Product c);

	void deleteProduct(long id);

}
