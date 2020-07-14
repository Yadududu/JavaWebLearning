package com.sikiedu.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sikiedu.domain.Paste;
import com.sikiedu.domain.User;
import com.sikiedu.service.PasteService;

public class PasteAction extends ActionSupport implements ModelDriven<Paste> {

	public Paste paste = new Paste();

	public String addPaste() throws Exception {

		// 没有的数据手动封装
		// title content offer
		// private Integer ansnum;
		paste.setAnsnum(0);
//		private Integer glanceover;
		paste.setGlanceover(0);
//		private String createtime;
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String createtime = format.format(date);
		paste.setCreatetime(createtime);
		User user = (User) ActionContext.getContext().getSession().get("user");
		paste.setUser(user);

		PasteService pasteService = new PasteService();
		pasteService.addPaste(paste);
		
		return "toIndex";
	}

	@Override
	public Paste getModel() {
		// TODO Auto-generated method stub
		return paste;
	}

}
