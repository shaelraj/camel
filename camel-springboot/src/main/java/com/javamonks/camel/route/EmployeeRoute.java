package com.javamonks.camel.route;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jacksonxml.JacksonXMLDataFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.javamonks.camel.model.Employee;

@Component
public class EmployeeRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		JacksonXMLDataFormat jacksonDataFormat = new JacksonXMLDataFormat();
        jacksonDataFormat.setPrettyPrint(true);
        jacksonDataFormat.enableFeature(SerializationFeature.WRAP_ROOT_VALUE);
        
		from("timer:SampleRoute?period=10000")
		.process(new Processor() {
			
			public void process(Exchange exchange) throws Exception {
				List<Employee> list = new ArrayList<>();
				Employee employee1 = new Employee("Franziska Waltraud", "HR Manager", 40000);
			    Employee employee2 = new Employee("Hubertus Andrea", "Software Engineer", 60000);
			    list.add(employee1);
			    list.add(employee2);
			    exchange.getIn().setBody(list);				
			}
		}).split(body())
			.marshal(jacksonDataFormat)
	         .log("XML Marshalled Body: ${body}").unmarshal(jacksonDataFormat).
             log("Unmarshalled JSON Body: ${body}");
		
	}

}
