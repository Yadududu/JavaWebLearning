package com.lmj.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lmj.bean.User;
import com.lmj.dao.UserDao;
import com.lmj.dao.UserDaoImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class JdbcTest {
	@Test
	public void Test1() {
		UserDao dao = new UserDaoImpl();
		User u = dao.selectUserById(1);
		System.out.println(u);
	}
	
	@Test
	public void Test2() {
		UserDao dao = new UserDaoImpl();
		User u = new User();
		u.setU_username("alice");
		u.setU_password("123123");
		dao.saveUser(u);
	}
	
	@Resource(name="userDao")
	private UserDao ud;
	
	@Test
	public void Test3() {
		User u = new User();
		u.setU_username("老王");
		u.setU_password("666");
		ud.saveUser(u);
	}
	
	@Test
	public void Test4() {
		User u = new User();
		u.setU_id(5);
		u.setU_username("老王");
		u.setU_password("777");
		ud.updateUser(u);
	}
	
	@Test
	public void Test5() {
		User u = ud.selectUserById(5);
		System.out.println(u);
	}
	
	@Test
	public void Test6() {
		List<User> list = ud.selectAllUser();
		for(User u:list) {
			System.out.println(u);
		}
	}
	
	@Test
	public void Test7() {
		Integer count = ud.selectUserCount();
		System.out.println(count);
	}
	
	@Test
	public void Test8() {
		ud.deleteUserById(8);
	}
}
