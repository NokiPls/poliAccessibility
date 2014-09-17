package com.access.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.access.domain.Product;


@SuppressWarnings("rawtypes")
public class GetRs implements ResultSetExtractor {

	@Override
	public Object extractData(ResultSet rs) throws SQLException {
		Product product = new Product();
		product.setBriefDescription(rs.getString(2));
		product.setCategory(rs.getString(3));
		product.setCompatibility(rs.getString(4));
		product.setFeatures(rs.getString(5));
		product.setImageURL(rs.getString(6));
		product.setLinkVideo(rs.getString(7));
		product.setLongDescription(rs.getString(8));
		product.setPrice(rs.getString(9));
		product.setProdName(rs.getString(10));
		product.setProductType(rs.getString(11));
		return product;
	}

}
