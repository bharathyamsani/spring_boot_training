package com.example.pcspringboot.dto;

import java.util.List;

import lombok.Data;

@Data
public class CategoryDto {
	private String name;
	private List<String> products;
}
