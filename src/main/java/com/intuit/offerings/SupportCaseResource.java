package com.intuit.offerings;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intuit.offerings.model.Case;
import com.intuit.offerings.model.CaseResponse;
import com.intuit.offerings.service.SupportCaseService;

@Path("/supportCase")
@Component
public class SupportCaseResource {

	@Autowired
	private SupportCaseService supportCaseService;

	@Autowired
	private CaseResponse response;

	@Path("/createCase")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public CaseResponse createSupportcase(Case c) {

		String status = supportCaseService.saveCase(c);

		if ("success".equals(status)) {
			response.setStatusCode(200);
			response.setStatusMessage("case is logged");
		} else {
			response.setStatusCode(400);
			response.setStatusMessage("case is not logged");
		}
		return response;

	}

	@Path("/updateCase")
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public CaseResponse updateSupportCase(Case c) {

		String status = supportCaseService.updateCase(c);

		if ("success".equals(status)) {
			response.setStatusCode(200);
			response.setStatusMessage("case is updated");
		} else {
			response.setStatusCode(400);
			response.setStatusMessage("case is not updated");
		}
		return response;


	}
	
	@Path("/getAllCases")
	@GET
	@Produces("application/json")
	public Case viewCaseForId(@QueryParam("id") int id) {

		Case cases=supportCaseService.getCaseForId(id);

		if (cases!=null) {
			response.setStatusCode(200);
			response.setStatusMessage("All cases are retrieved");
		} else {
			response.setStatusCode(400);
			response.setStatusMessage("cases are not retrieved");
		}
		return cases;


	}

}
