package com.sikiedu.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class ImplAction implements Action {

	@Override
	public String execute() throws Exception {
		System.err.println("这是实现了Action接口的action");
		return "defaultAction";
	}
	
	
	public String login() throws Exception 
	{
		//得到原生的request域
		//ServletActionContext.getRequest().setAttribute("username", "123");
		//ServletActionContext.getRequest().setAttribute("password", "123");
		
		//request中setAttr
		ActionContext.getContext().put("username", "123");
		ActionContext.getContext().put("password", "123");
		
		//获得session
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("mysession", "这是session域");
		//获得Application
		Map<String, Object> application = ActionContext.getContext().getApplication();
		application.put("myapplication", "这是application域");
		
		//获得原生的request
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//获得原声的response
		HttpServletResponse response = ServletActionContext.getResponse();
		
		return "toLogin";
	}
	

}
