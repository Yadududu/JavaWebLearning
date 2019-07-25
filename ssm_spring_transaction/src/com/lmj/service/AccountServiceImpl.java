package com.lmj.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lmj.dao.AccountDao;

@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED, readOnly=true)
public class AccountServiceImpl implements AccountService {

	//账户dao
	private AccountDao ad;
	
	public void setAd(AccountDao ad) {
		this.ad = ad;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED, readOnly=false)
	public void transferAccounts() {
		//转账逻辑
		
		//先从A账户扣款
		ad.subMoney(1,50d);
		int a = 1/0;
		
		//再从B账户加款
		ad.addMoney(2,50d);
	}

}
