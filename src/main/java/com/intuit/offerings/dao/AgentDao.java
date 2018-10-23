package com.intuit.offerings.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.intuit.offerings.model.Agent;
import com.intuit.offerings.model.Case;

@Component
public class AgentDao {
	@Autowired
	private JdbcTemplate template;
	
	public List<Agent> getAllAgents(){
		 final String SELECT_SQL = "SELECT * FROM `Agents`;";
		List<Agent> agents=template.query(SELECT_SQL, new BeanPropertyRowMapper<Agent>(Agent.class));
		return agents;
		
	 }
	
	@SuppressWarnings("unchecked")
	public Agent getAgentsByOffering(String offering){
		final String SELECT_SQL = "SELECT * FROM `Agents` where agentSkill=?;";
		Agent agent=(Agent)template.queryForObject(
				SELECT_SQL, new Object[] { offering }, 
				new BeanPropertyRowMapper(Agent.class));
		return agent;
		
	}
	
	public String assignCaseToAgent(Case c){
		Agent agent=getAgentsByOffering(c.getOffering());
		final String INSERT_SQL="INSERT INTO   `case_agent` (`case_id`, `agentName`) VALUES (?, ?);";
		int returnValue=  template.update(INSERT_SQL,
				 new Object[] {c.getCaseId(), agent.getAgentName() });
			        if(1 == returnValue)
			            return "success";
			        else
			            return "failure";
	}

}
