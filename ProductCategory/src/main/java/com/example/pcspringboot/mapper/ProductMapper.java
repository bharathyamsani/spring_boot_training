package com.example.pcspringboot.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.pcspringboot.dto.ProductDto;
import com.example.pcspringboot.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	@Mapping(target = "categoryName", source = "category.categoryName")
	ProductDto getProductDto(Product p);

	List<ProductDto> getListDto(List<Product> p);

}
