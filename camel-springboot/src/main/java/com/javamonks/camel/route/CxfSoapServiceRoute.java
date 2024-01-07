/*
 * package com.javamonks.camel.route;
 * 
 * import org.apache.camel.builder.RouteBuilder; import
 * org.springframework.stereotype.Component;
 * 
 * @Component public class CxfSoapServiceRoute extends RouteBuilder{
 * 
 * @Override public void configure() throws Exception { final String
 * getEmployeeDetailProcessor = "getEmployeeDetailProcessor";
 * 
 * from("cxf:bean:endpoint")
 * .id("httpGetEmployeeDetailRoute").to(getEmployeeDetailProcessor); }
 * 
 * }
 */