package com.sandy.services.soap.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ClientAppConfig {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.tavant.service.wsdl");
		return marshaller;
	}
	@Bean
	public EmployeeClient employeeClient(Jaxb2Marshaller marshaller) {
		EmployeeClient client = new EmployeeClient();
		client.setDefaultUri("https://employeeservice.herokuapp.com/ws/employees.wsdl");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
