package com.sikiedu.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sikiedu.domain.Answer;
import com.sikiedu.domain.Paste;
import com.sikiedu.domain.User;
import com.sikiedu.service.AnswerService;
import com.sikiedu.service.PasteService;

public class AnswerAction extends ActionSupport implements ModelDriven<Answer> {

	public Answer answer = new Answer();
	public String pasteid;

	public String addAnswer() throws Exception {

		AnswerService answerService = new AnswerService();
		PasteService pasteService = new PasteService();
		
		Paste paste = pasteService.findPasteById(pasteid);
		answer.setPaste(paste);
		User user = (User) ActionContext.getContext().getSession().get("user");
		answer.setUser(user);

		System.out.println(pasteid + " --- "+answer.getContent());
		answerService.addAnswer(answer);

		return "success";
	}

	public String getPasteid() {
		return pasteid;
	}

	public void setPasteid(String pasteid) {
		this.pasteid = pasteid;
	}

	@Override
	public Answer getModel() {
		// TODO Auto-generated method stub
		return answer;
	}

}
