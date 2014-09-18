package com.access.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.access.domain.Product;

public class JDBCProd implements ProductsDao {

	private DataSource dataSource;

	public void setDataSource(DataSource ds) {
		dataSource = ds;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> selectCategory(String category) {
		JdbcTemplate select = new JdbcTemplate(dataSource);
		return select.query("select * from PRODUCT where CATEGORY = ?",
				new Object[] { category }, new Mapper());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> selectType(String type) {
		JdbcTemplate select = new JdbcTemplate(dataSource);
		return select.query("select * from PRODUCT where PRODUCTTYPE = ?",
				new Object[] { type }, new Mapper());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> selectAll() {
		JdbcTemplate select = new JdbcTemplate(dataSource);
		return select.query("select * from PRODUCT", new Object[] {},
				new Mapper());
	}

}
