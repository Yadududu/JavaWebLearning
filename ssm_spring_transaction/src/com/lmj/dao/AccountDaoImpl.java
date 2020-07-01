package com.lmj.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

	@Override
	public void subMoney(Integer id, double money) {
		String sql = "update account set money = money - ? where id = ?";
		getJdbcTemplate().update(sql,money,id);
	}

	@Override
	public void addMoney(Integer id, double money) {
		String sql = "update account set money = money + ? where id = ?";
		getJdbcTemplate().update(sql,money,id);
	}

}
