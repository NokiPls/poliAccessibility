package com.access.repository;

import java.util.List;

import com.access.domain.Product;

public interface ProductsDao {

	public List<Product> selectCategory(String category);

	public List<Product> selectType(String type);

	public List<Product> selectAll();
}
