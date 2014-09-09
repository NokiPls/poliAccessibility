package com.access.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.access.domain.Product;

public class GetRs implements ResultSetExtractor {

	@Override
	public Object extractData(ResultSet rs) throws SQLException {
		Product product = new Product();
		product.setBriefDescription(rs.getString(2));
		product.setCategory(rs.getString(3));
		product.setImageURL(rs.getString(4));
		product.setLinkVideo(rs.getString(5));
		product.setLongDescription(rs.getString(6));
		product.setProdName(rs.getString(7));
		product.setPrice(rs.getString(8));
		product.setSpecs(rs.getString(9));
		return product;
	}

}
