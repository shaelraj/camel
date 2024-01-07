package com.javamonks.camel.soap.config;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SaopWsConfig extends WsConfigurerAdapter{
	
	private CamelContext context;
	
	@Autowired
	public void setContext(CamelContext context) {
		this.context = context;
	}

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(context);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/ws/*");
	}

	@Bean(name = "loanEligibility")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
		DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
		defaultWsdl11Definition.setPortTypeName("LoanEligibilityindicator");
		defaultWsdl11Definition.setLocationUri("/ws/LoanEligibilityService");
		defaultWsdl11Definition.setTargetNamespace("http://www.javamonks.com/camel/soap/api/loanEligibility");
		defaultWsdl11Definition.setSchema(schema);
		return defaultWsdl11Definition;

	}

	@Bean
	public XsdSchema schema() {
		return new SimpleXsdSchema(new ClassPathResource("loaneligibility.xsd"));
	}
	
	/*
	 * @Bean("endpoint") public CxfEndpoint getCxfEndpoint() { CxfComponent
	 * cxfComponent = new CxfComponent(context); CxfEndpoint serviceEndpoint = new
	 * CxfEndpoint("/EmployeeDetailService/GetEmployeeDetail", cxfComponent);
	 * serviceEndpoint.setServiceClass(LoanEligibilityService.class);
	 * serviceEndpoint.setEndpointName("LoanEligibilityindicator");
	 * serviceEndpoint.setWsdlURL("META-INF/wsdl/loanEligibility.wsdl");
	 * serviceEndpoint.setAddress(
	 * "http://www.javamonks.com/camel/soap/api/loanEligibility"); return
	 * serviceEndpoint; }
	 */

}
