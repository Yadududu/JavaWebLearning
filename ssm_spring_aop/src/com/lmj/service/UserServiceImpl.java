package com.lmj.service;

public class UserServiceImpl implements UserService{

	@Override
	public void save() {
		System.out.println("save");
	}

	@Override
	public void delete() {
		System.out.println("delete");
//		int a = 1/0;
	}

	@Override
	public void update() {
		System.out.println("update");
	}

	@Override
	public void find() {
		System.out.println("find");
	}

}
