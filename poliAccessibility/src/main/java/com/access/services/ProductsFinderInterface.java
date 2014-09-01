package com.access.services;

import java.util.List;

import com.access.domain.Product;

public interface ProductsFinderInterface {
	public void init();
	public List<Product> findProducts(String category);
}
