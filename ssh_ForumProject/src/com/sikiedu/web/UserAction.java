package com.sikiedu.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sikiedu.domain.User;
import com.sikiedu.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	public User user = new User();

	public String login() throws Exception {
		
		//封装User

		//调用UserService中的判断用户是否存在的方法
		UserService userService = new UserService();
		boolean isSuccess = userService.findUser(user);
		//拿到返回值
		if(isSuccess)
		{
			//成功   index.html 在session域中放置user对象
			ActionContext.getContext().getSession().put("user", user);
			return "getAllPaste";
		}
		else
		{
			//失败   添加错误信息 转发到login.jsp
			ActionContext.getContext().put("error", "用户名或者密码错误!!");
			return "login";
		}
						
	}

	
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	
	
	
	
}
