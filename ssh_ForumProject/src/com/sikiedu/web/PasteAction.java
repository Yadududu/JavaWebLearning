package com.sikiedu.web;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sikiedu.domain.Paste;
import com.sikiedu.service.PasteService;

public class PasteAction extends ActionSupport {


	public String getAllPaste() throws Exception {
		
		PasteService pasteService = new PasteService();
		
		
		List<Paste> pasteList = pasteService.findAllPaste();
		
		ActionContext.getContext().put("pasteList", pasteList);
		
		return "index";
	}

	
	
}
