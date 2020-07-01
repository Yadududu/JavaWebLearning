package com.sikiedu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sikiedu.domain.Paste;
import com.yl.lain.utils.C3p0DataSourceUtils;

public class PasteDao {

	public List<Paste> findAllPaste() throws SQLException {
		QueryRunner runner = new QueryRunner(C3p0DataSourceUtils.getDataSource());
		String sql = "select * from paste";
		return runner.query(sql, new BeanListHandler<Paste>(Paste.class));
	}

}
