package com.OnlineBanking.api;

import java.util.List;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.OnlineBanking.beans.Customers;
import com.OnlineBanking.services.CustomerService;


//-- CLASS URL - http://18.221.148.153:8082/OnlineBankingSystem/rest/customer
@Path("/customer")
public class CustomerAPI {
	
	//-- API url for testing
	//-- GET - http://18.221.148.153:8082/OnlineBankingSystem/rest/customer/get/all
	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customers> getAllCust(){
		return CustomerService.getAllCust();
	}

	//-- API url for testing
	//-- GET - http://18.221.148.153:8082/OnlineBankingSystem/rest/customer/get/{ssn}
	@GET
	@Path("/get/{ssn}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customers getCustBySSN(@PathParam("ssn") int ssn) {
		return CustomerService.getCustBySSN(ssn);
	}
	
	//-- API url for testing
	//-- GET - http://18.221.148.153:8082/OnlineBankingSystem/rest/customer/get/{username}/{pw}
	// -- http://18.221.148.153:8082/OnlineBankingSystem/rest/customer/get/AHOSNY12/NEWPASSWORD12
	@GET
	@Path("/get/{username}/{pw}")
	@Produces(MediaType.APPLICATION_JSON)
	public Integer loginCust(@PathParam("username") String username, @PathParam("pw") String pw) {
		Integer CIS = null;
		CIS = CustomerService.loginCust(username, pw);
		return CIS;
	}
	
	//-- API url for testing
	//-- POST - http://18.221.148.153:8082/OnlineBankingSystem/rest/customer/post
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Integer createCustomer(JsonObject json) {
		
		String type = json.getString("type");
		Integer id = null;
		
		if(type.equals("Retail")) {
			id = CustomerService.insertCustRT(json.getString("username"), json.getString("password"), json.getString("firstname"), json.getString("lastname"),
					json.getInt("ssn"), json.getString("phone"), json.getString("email"));
		
		}else if (type.equals("SB")) {
			id = CustomerService.insertCustRT(json.getString("username"), json.getString("password"), json.getString("firstname"), json.getString("lastname"),
					json.getInt("ssn"), json.getString("phone"), json.getString("email"));
			
		}
			return id;
	}
	
	
	
	
	
	
	
}
