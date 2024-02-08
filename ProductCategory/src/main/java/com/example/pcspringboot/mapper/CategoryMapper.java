package com.example.pcspringboot.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.pcspringboot.dto.CategoryDto;
import com.example.pcspringboot.model.Category;
import com.example.pcspringboot.model.Product;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

	@Mapping(target = "name", source = "categoryName")
	CategoryDto toCategoryDto(Category c);

	default List<String> getListOfStrings(List<Product> products) {
		return products.stream().map(a -> a.getProductName()).toList();
	}

	List<CategoryDto> getListOfCategoryDto(List<Category> l);
}
