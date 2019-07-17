package com.lmj.bean;

import java.util.List;

public class UserVo extends User{
	//包装类
	private User user;
	private Country country;
	
	private List<Integer> idList;
	
	public List<Integer> getIdList() {
		return idList;
	}

	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}

	//需要全部的User对象信息
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "UserVo [country=" + country + ", getU_id()=" + getU_id() + ", getU_username()=" + getU_username()
				+ ", getU_sex()=" + getU_sex() + "]";
	}
	
	
	//需要表B的id name属性
}
