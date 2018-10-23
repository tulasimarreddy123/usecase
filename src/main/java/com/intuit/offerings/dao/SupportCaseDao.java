package com.intuit.offerings.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Component;

import com.intuit.offerings.model.Case;

@Component
public class SupportCaseDao {
	
	@Autowired
	private JdbcTemplate template;
	
	 public void saveCase1(final Case c){
		 final String INSERT_SQL = "INSERT INTO `CaseDetails` (`case_id`, `case_title`, `case_status`, `customer`, 'offering') VALUES (NULL, ?, ?, ?, ?);";
		 template.update(
				 new PreparedStatementCreator() {

						public PreparedStatement createPreparedStatement(Connection con)
								throws SQLException {
							PreparedStatement ps = con.prepareStatement(INSERT_SQL);
							ps.setString(2, c.getCaseTitle());
							ps.setString(3, c.getCaseStatus());
							ps.setString(4, c.getCustomerName());
							ps.setString(5, c.getOffering());
							return ps;
						}

					});
	 }
	 
	 public String saveCase(Case c){
		 final String INSERT_SQL = "INSERT INTO `CaseDetails` (`case_id`, `case_title`, `case_status`, `customer`,  `offering`) VALUES (?, ?, ?, ?, ?);";
		int returnValue=  template.update(INSERT_SQL,
		 new Object[] {c.getCaseId(), c.getCaseTitle(), c.getCaseStatus(), c.getCustomerName(),c.getOffering() });
	        if(1 == returnValue)
	            return "success";
	        else
	            return "failure";
	 }
	 
	 public String updateCase(Case c){
		 final String UPDATE_SQL = "UPDATE `CaseDetails` SET `case_title`=?, `case_status`=? WHERE `case_id`=?;";
		int returnValue=  template.update(UPDATE_SQL,
		 new Object[] {c.getCaseTitle(), c.getCaseStatus(), c.getCaseId() });
	        if(1 == returnValue)
	            return "success";
	        else
	            return "failure";
	 }
	 
	 @SuppressWarnings("unchecked")
	public Case getCaseForId(int id){
		 Case scase=null;
		 final String SELECT_SQL = "SELECT * FROM `CaseDetails`  WHERE `case_id`=?;";
		scase=(Case)template.queryForObject(
				SELECT_SQL, new Object[] { id }, 
				new BeanPropertyRowMapper(Case.class));
		return scase;
		
	 }
	 
	 public List<Case> getAllCases(int id){
		 final String SELECT_SQL = "SELECT * FROM `CaseDetails`  WHERE `case_id`=?;";
		List<Case> cases=template.query(SELECT_SQL, new BeanPropertyRowMapper<Case>(Case.class));
		return cases;
		
	 }
	 

}
