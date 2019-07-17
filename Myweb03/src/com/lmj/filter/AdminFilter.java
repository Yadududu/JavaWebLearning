package com.lmj.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmj.model.User;

/**
 * Servlet Filter implementation class AdminFilter
 */
//@WebFilter("/Admin/*")
public class AdminFilter implements Filter {
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
//		System.out.println("doFilter");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		Object o = req.getSession().getAttribute("user");
		if(o!=null) {
			User user=(User)o;
			if(user.isAdmin()) {
				chain.doFilter(request, response);
			}else {
				res.sendRedirect(req.getContextPath() + "/index.jsp");
			}
		}else {
			res.sendRedirect(req.getContextPath() + "/index.jsp");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
