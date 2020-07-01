package com.sikiedu.util;

public class UserTest {
	@Override
	public String toString() {
		return "UserTest [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	private String name;
	private String sex;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public UserTest(String name, String sex, int age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	
}
