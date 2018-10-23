package com.intuit.offerings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intuit.offerings.dao.SupportCaseDao;
import com.intuit.offerings.model.Agent;
import com.intuit.offerings.model.Case;

@Component
public class SupportCaseService {
	
	@Autowired
	private SupportCaseDao caseDao;
	

	public String saveCase(Case c) {
		return caseDao.saveCase(c);
		
	}
	
	public String updateCase(Case c) {
		return caseDao.updateCase(c);
		
	}
	
	public List<Case> getAllCases(int id) {
		return caseDao.getAllCases(id);
		
	}
	
	public Case getCaseForId(int id) {
		return caseDao.getCaseForId(id);
		
	}
	
	

}
