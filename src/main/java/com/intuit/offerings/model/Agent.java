package com.intuit.offerings.model;

import org.springframework.stereotype.Component;

@Component
public class Agent {
	private int agentId;
	private String agentName;
	private String agentSkill;
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getAgentSkill() {
		return agentSkill;
	}
	public void setAgentSkill(String agentSkill) {
		this.agentSkill = agentSkill;
	}
	
	

}
