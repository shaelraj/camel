package com.javamonks.camel.soap.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.javamonks.camel.soap.api.Acknowledgement;
import com.javamonks.camel.soap.api.CustomerRequest;
import com.javamonks.camel.soap.service.LoanEligibilityService;

@Endpoint
public class LoanEligibilityindicatorEndpoint {

	private static final String NAMESPACE = "http://www.javamonks.com/camel/soap/api/loanEligibility";
	@Autowired
	private LoanEligibilityService service;

	@PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
		return service.checkLoanEligibility(request);
	}

}
