package com.access.repository;

import java.util.List;

import com.access.domain.Product;

public interface ProductsDao {

	public List<Product> selectCategory(String category);
}
