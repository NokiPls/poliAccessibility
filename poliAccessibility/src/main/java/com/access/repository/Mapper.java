package com.access.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class Mapper implements RowMapper {

	  @Override
	  public Object mapRow(ResultSet rs, int line) throws SQLException {
	    GetRs extractor = new GetRs();
	    return extractor.extractData(rs);
	  }

	} 