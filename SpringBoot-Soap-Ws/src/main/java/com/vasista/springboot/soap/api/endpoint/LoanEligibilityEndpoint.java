package com.vasista.springboot.soap.api.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.vasista.springboot.soap.api.loaneligibility.Acknowledgement;
import com.vasista.springboot.soap.api.loaneligibility.CustomerRequest;
import com.vasista.springboot.soap.api.service.LoanEligibilityService;

@Endpoint
public class LoanEligibilityEndpoint {

	private static final String NAMESPACE ="http://www.vasista.com/springboot/soap/api/loanEligibility";
	
	@Autowired
	private LoanEligibilityService service;
	
	@PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
		return service.checkLoanEgilibilty(request);
	}
}
