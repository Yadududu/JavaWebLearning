package com.sikiedu.web;

import java.util.List;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sikiedu.domain.Paste;
import com.sikiedu.domain.User;
import com.sikiedu.service.PasteService;

public class PasteAction extends ActionSupport {


	public String getAllPaste() throws Exception {
		
		PasteService pasteService = new PasteService();
		List<Paste> pasteList = pasteService.findAllPaste();
		
		User user = new User();
		user.setUsername("Lain");
		user.setPassword("111");
		ActionContext.getContext().put("pasteList", pasteList);
		ActionContext.getContext().put("user", user);
		System.out.println(pasteList);
		
		return "index";
	}

	
	
}
