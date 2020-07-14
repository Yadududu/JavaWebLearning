package com.sikiedu.service;

import org.hibernate.Transaction;

import com.sikiedu.dao.AnswerDao;
import com.sikiedu.domain.Answer;
import com.sikiedu.utils.HibernateUtils;

public class AnswerService {

	public void addAnswer(Answer answer) {
		
		AnswerDao answerDao = new AnswerDao();
		Transaction beginTransaction = HibernateUtils.getCurrentSession().beginTransaction();
		try {
			answerDao.addAnswer(answer);			
		}
		catch (Exception e) {
			beginTransaction.rollback();
		}
		
		beginTransaction.commit();
	}

}
