package com.sikiedu.service;

import org.hibernate.Transaction;

import com.sikiedu.dao.PasteDao;
import com.sikiedu.domain.Paste;
import com.sikiedu.utils.HibernateUtils;

public class PasteService {

	public void addPaste(Paste paste) {

		PasteDao pasteDao = new PasteDao();

		Transaction beginTransaction = HibernateUtils.getCurrentSession().beginTransaction();

		try {
			pasteDao.addPaste(paste);
		} catch (Exception e) {
			beginTransaction.rollback();
		}

		beginTransaction.commit();

	}

	public Paste findPasteById(String pasteid) {
		
		PasteDao pasteDao = new PasteDao();
		Paste paste = null;
		Transaction beginTransaction = HibernateUtils.getCurrentSession().beginTransaction();
		try {
			paste = pasteDao.findPasteById(pasteid);			
		}catch (Exception e) {
			beginTransaction.rollback();
		}
		beginTransaction.commit();
		return paste;
	}

}
