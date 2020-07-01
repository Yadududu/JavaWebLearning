package com.lmj.mapper;

import com.lmj.bean.Account;

/**
 * 账户mapper接口
 * 
 * */
public interface AccountMapper {
	//操作数据库扣款和加款
	
	//扣款
	void subMoney(Account pay);
	
	//加款
	void addMoney(Account collect);
}
