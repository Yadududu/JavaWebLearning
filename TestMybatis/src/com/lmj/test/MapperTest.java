package com.lmj.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.lmj.bean.Country;
import com.lmj.bean.CountryVo;
import com.lmj.bean.User;
import com.lmj.bean.UserVo;
import com.lmj.mapper.CountryMapper;
import com.lmj.mapper.UserMapper;

public class MapperTest {
	@Test
	public void text1() throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		//操作数据库
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.selectUserById(1);
		System.out.println(user);
	}
	
	@Test
	public void text2() throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		//操作数据库
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list = mapper.selectUserByName("王");
		for(User user:list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void Text_selectUserByUserVoId() throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		//操作数据库
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		UserVo vo = new UserVo();
		User u = new User();
		u.setU_id(1);
		vo.setUser(u);
		
		User user = mapper.selectUserVobyId(vo);
		System.out.println(user);
	}
	
	@Test
	public void Text_selectUserCount() throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		//操作数据库
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		Integer count = mapper.selectUserCount();
		System.out.println(count);
	}
	
	@Test
	public void Text_selectAll() throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		//操作数据库
		
		CountryMapper mapper = session.getMapper(CountryMapper.class);
		List<Country> list = mapper.selectAll();
		for(Country country:list) {
			System.out.println(country);
		}
	}
	
	@Test
	public void Text_selectAllUserVo() throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		//操作数据库
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<UserVo> list = mapper.selectAllUserVo();
		for(UserVo userVo:list) {
			System.out.println(userVo);
		}
	}
	
	@Test
	public void Text_selectAllCountryVo() throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		//操作数据库
		
		CountryMapper mapper = session.getMapper(CountryMapper.class);
		List<CountryVo> list = mapper.selectAllCountryVo();
		for(CountryVo countryVo:list) {
			System.out.println(countryVo);
		}
	}
	
	@Test
	public void Text_selectUserListByUser() throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		//操作数据库
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		User u = new User();
		//u.setU_sex("1");
		u.setU_username("王");
		//u.setU_cid(1);
		
		List<User> list = mapper.selectUserListByUser(u);
		for(User user:list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void Text_selectUserListByUserTrim() throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		//操作数据库
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		User u = new User();
		u.setU_sex("1");
		u.setU_username("王");
		//u.setU_cid(1);
		
		List<User> list = mapper.selectUserListByUser(u);
		for(User user:list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void Text_updateSetUser() throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		//操作数据库
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		User u = new User();
		u.setU_id(1);
		u.setU_username("老王");
		u.setU_password("aaa");
//		u.setU_sex("1");
		
		mapper.updateSetUser(u);
		session.commit();
	}
	
	@Test
	public void Text_selectUserListByIds() throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		//操作数据库
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		Integer[] ids = {1,3,5,12};
		List<User> list = mapper.selectUserListByIds(ids);
		
		for(User user:list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void Text_selectUserListByList() throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		//操作数据库
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<Integer> idlist = new ArrayList<Integer>();
		idlist.add(1);
		idlist.add(3);
		idlist.add(5);
		
		List<User> list = mapper.selectUserListByList(idlist);
		
		for(User user:list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void Text_selectUserListByUserVo() throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		//操作数据库
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<Integer> idlist = new ArrayList<Integer>();
		idlist.add(1);
		idlist.add(3);
		idlist.add(5);
		
		UserVo userVo = new UserVo();
		userVo.setIdList(idlist);
		
		List<User> list = mapper.selectUserListByUserVo(userVo);
		
		for(User user:list) {
			System.out.println(user);
		}
	}
}

