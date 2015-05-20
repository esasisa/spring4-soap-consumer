package com.sandy.consumer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sandy.services.soap.consumer.ClientAppConfig;
import com.sandy.services.soap.consumer.EmployeeClient;
import com.tavant.service.wsdl.GetEmployeeResponse;

public class RunSoapClient {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	    ctx.register(ClientAppConfig.class);
	    ctx.refresh();
		EmployeeClient studentClient = ctx.getBean(EmployeeClient.class);
		System.out.println("For Employee Id: 1");
		GetEmployeeResponse response = studentClient.getEmployeeById(1);
		System.out.println("Name:"+response.getEmployee().getName());
		System.out.println("Country:"+response.getEmployee().getCountry());
		System.out.println("Department:"+response.getEmployee().getDepartment());
	}
}
