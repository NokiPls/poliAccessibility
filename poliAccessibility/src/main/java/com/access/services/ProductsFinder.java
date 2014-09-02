package com.access.services;

import java.util.List;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import com.access.domain.Product;
import com.access.repository.JDBCProd;

@Service
public class ProductsFinder implements ProductsFinderInterface {

	private JDBCProd dao;

	@Override
	public void init() {
		dao = new JDBCProd();
		// Initialize the datasource, could /should be done of Spring
		// configuration
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/accessibility");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		// Inject the datasource into the dao
		dao.setDataSource(dataSource);
	}

	@Override
	public List<Product> findProducts(String category) {
		return dao.selectCategory(category);
	}

}
