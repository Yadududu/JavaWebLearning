package com.lmj.dao;

public interface AccountDao {

	//¿Û¿î
	void subMoney(Integer id, double money);
	
	//¼Ó¿î
	void addMoney(Integer id, double money);

}
