package com.lmj.mapper;

import java.util.List;

import com.lmj.bean.User;
import com.lmj.bean.UserVo;

public interface UserMapper {
	//mapper动态代理开发四大原则 + 一个注意
		//1、接口方法名需要与mapper.xml的要调用的sql语句的id一致
		//2、接口的形参类型需要与mapper.xml parameterType 一致
		//3、接口的返回值需要与mapper.xml resultType一致
		//4、mapper.xml 中namespace要与接口的全包名一致
		//5、注意mapper动态代理开发中，根据返回值类型来自动选择
	
	//通过id查询一个用户
	public User selectUserById(Integer id);
	
	//通过用户名模糊查询 获取用户列表
	public List<User> selectUserByName(String name);
	
	//通过UserVo id查询一个用户
	public User selectUserVobyId(UserVo vo);
	
	//查询用户总条数
	public Integer selectUserCount();
	
	//查询所有用户包装类
	public List<UserVo> selectAllUserVo();
	
	//多条件查询通过对象中的条件查询用户列表
	public List<User> selectUserListByUser(User u);
	
	//多条件查询 通过用户对象中的条件查询用户列表Trim
	public List<User> selectUserListByUserTrim(User u);
	
	//更新用户表
	public void updateSetUser(User u);
	
	//使用多个id获取用户列表by array
	public List<User> selectUserListByIds(Integer[] ids);
	
	//使用多个id获取用户列表 by list
	public List<User> selectUserListByList(List<Integer> idList);
	
	//使用多个id获取用户列表 by userVO
	public List<User> selectUserListByUserVo(UserVo vo);
}
