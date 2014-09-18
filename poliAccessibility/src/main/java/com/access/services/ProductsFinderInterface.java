package com.access.services;

import java.util.List;

import com.access.domain.Product;

public interface ProductsFinderInterface {
	public void init();

	public List<Product> findProductsByCategory(String category);

	public List<Product> findProductsByType(String type);

	public List<Product> findAllProducts();
}
