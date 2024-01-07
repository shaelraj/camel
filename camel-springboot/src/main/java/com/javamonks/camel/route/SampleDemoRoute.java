/**
 * 
 */
package com.javamonks.camel.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author shael
 *
 */
@Component
public class SampleDemoRoute extends RouteBuilder{
	
	private static boolean flag = true;

	@Override
	public void configure() throws Exception {
		from("timer:SampleRoute?period=10000")
		.routeId("SampleRoute")
		.setProperty("CounterFlag", constant(flag))
		.choice()
			.when(exchangeProperty("CounterFlag"))
				.log(">>>>>>>>>>>>>>> Counter is true")
				.process(new Processor() {
					
					public void process(Exchange exchange) throws Exception {
						SampleDemoRoute.flag = false;
						exchange.getIn().setBody("$$$$$$$$$$$$$$");
					}
				})
				.to("direct:start")
				.endChoice()
			.otherwise()
			.log("@@@@@@@@@@@@@@@@@@@ Couter is false")
			.endChoice().end();
		
		from("direct:foo")
		.routeId("foo")
		.log("hello world!!!!!!!!" + bodyAs(String.class))
		.process(new Processor() {
			
			public void process(Exchange exchange) throws Exception {
				exchange.getIn().setBody("############");
			}
		});
		
		from("direct:bar")
		.routeId("bar")
		.log("welcome to hell!!!!!!!!" + bodyAs(String.class));
		
		from("direct:start")
		  .multicast().parallelProcessing()
		  .process(new Processor() {
				
				public void process(Exchange exchange) throws Exception {
					exchange.getIn().setBody("############");
				}
			})
		    .to("direct:foo")
		    .to("direct:bar");
		
	}

	
}
