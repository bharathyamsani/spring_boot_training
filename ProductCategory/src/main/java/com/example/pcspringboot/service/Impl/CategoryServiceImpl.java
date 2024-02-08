package com.example.pcspringboot.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pcspringboot.Repository.CategoryRepository;
import com.example.pcspringboot.dto.CategoryDto;
import com.example.pcspringboot.mapper.CategoryMapper;
import com.example.pcspringboot.model.Category;
import com.example.pcspringboot.model.Product;
import com.example.pcspringboot.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public Category addCategory(Category c) {
		for (Product p : c.getProducts()) {
			p.setCategory(c);
		}
		return categoryRepository.save(c);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		return categoryMapper.getListOfCategoryDto(categoryRepository.findAll());
	}

	@Override
	public CategoryDto getCategory(long id) {
		return categoryMapper.toCategoryDto(categoryRepository.findById(id).get());
	}

	@Override
	public Category updateCategory(long id, Category c) {
		Category pc = categoryRepository.findById(id).get();
		pc.setCategoryName(c.getCategoryName());
		pc.setProducts(c.getProducts());
		return categoryRepository.save(pc);
	}

	@Override
	public void deleteCategory(long id) {
		categoryRepository.deleteById(id);
		return;
	}

}
