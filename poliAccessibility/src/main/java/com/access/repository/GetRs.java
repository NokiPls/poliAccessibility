package com.access.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.access.domain.Product;

public class GetRs implements ResultSetExtractor {

	@Override
	public Object extractData(ResultSet rs) throws SQLException {
		Product product = new Product();
		product.setName(rs.getString(1));
		product.setBriefDescription(rs.getString(2));
		return product;
	}

}
