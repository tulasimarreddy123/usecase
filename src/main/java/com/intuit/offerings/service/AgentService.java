package com.intuit.offerings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.intuit.offerings.dao.AgentDao;
import com.intuit.offerings.model.Agent;
import com.intuit.offerings.model.Case;

public class AgentService {
	
	@Autowired
	private AgentDao agentDao;
	
public List<Agent> getAllAgents(){
		return agentDao.getAllAgents();
	}

public Agent getAgentsByOffering(String offering){
	Agent agent=agentDao.getAgentsByOffering(offering);
	return agent;
	
}

public String assigncaseToAgent(Case c){
String status=agentDao.assignCaseToAgent(c);	
return status;
	
}

}
