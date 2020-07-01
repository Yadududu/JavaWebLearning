package com.lmj.service;

import javax.annotation.Resource;

import com.lmj.bean.Account;
import com.lmj.mapper.AccountMapper;

public class AccountServiceImpl implements AccountService {

	@Resource(type=AccountMapper.class)
	private AccountMapper mapper;
	@Override
	public void updateTranferAccount() {
		
		Double tranferMoney = 10d;
		
		Account pay = new Account();
		pay.setId(1);
		pay.setTranferManey(tranferMoney);
		//先扣款
		mapper.subMoney(pay);
		
		int a = 1/0;
		
		Account collect = new Account();
		collect.setId(2);
		collect.setTranferManey(tranferMoney);
		//加款
		mapper.addMoney(collect );
	}

}
