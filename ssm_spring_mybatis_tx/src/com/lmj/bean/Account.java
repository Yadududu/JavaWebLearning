package com.lmj.bean;

public class Account {
	private Integer id;
	private String name;
	private Double money;
	
	//в╙ук╫П╤Н
	private Double tranferManey;
	
	public Double getTranferManey() {
		return tranferManey;
	}
	public void setTranferManey(Double tranferManey) {
		this.tranferManey = tranferManey;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	
	
}
