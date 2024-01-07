package com.javamonks.camel.soap.service;

import com.javamonks.camel.soap.api.Acknowledgement;
import com.javamonks.camel.soap.api.CustomerRequest;

//@WebService(targetNamespace = "http://www.javamonks.com/camel/soap/api/loanEligibility/", name = "LoanEligibilityService")
public interface LoanEligibilityService {

	public Acknowledgement checkLoanEligibility(CustomerRequest request);
}
