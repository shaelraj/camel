//package com.javamonks.camel.processor;
//
//import org.apache.camel.Exchange;
//import org.apache.camel.Processor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.javamonks.camel.soap.api.Acknowledgement;
//import com.javamonks.camel.soap.api.CustomerRequest;
//import com.javamonks.camel.soap.service.LoanEligibilityService;
//
//@Service("getEmployeeDetailProcessor")
//public class LoanEligibilityProcessor implements Processor{
//
//	/** The Constant logger. */
//	private static final Logger logger = LoggerFactory.getLogger(LoanEligibilityProcessor.class.getName());
//	
//	@Autowired
//	private LoanEligibilityService service;
//    
//    @Override
//    public void process(Exchange exchange) throws Exception {
//    	
//        CustomerRequest request = exchange.getIn().getBody(CustomerRequest.class);
//        Acknowledgement response = getAcknowledgement(request);      
//        exchange.getOut().setBody(response);
//    }
//    
//    private Acknowledgement getAcknowledgement(CustomerRequest request) {
//    	return service.checkLoanEligibility(request);
//    }
//
//}
