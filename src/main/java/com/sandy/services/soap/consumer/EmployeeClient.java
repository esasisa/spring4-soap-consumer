package com.sandy.services.soap.consumer;

import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.tavant.service.wsdl.DeleteEmployeeRequest;
import com.tavant.service.wsdl.Employee;
import com.tavant.service.wsdl.GetEmployeeRequest;
import com.tavant.service.wsdl.GetEmployeeResponse;
import com.tavant.service.wsdl.ListAllEmployeeRequest;
import com.tavant.service.wsdl.ListAllEmployeeResponse;
import com.tavant.service.wsdl.SaveEmployeeRequest;
import com.tavant.service.wsdl.SaveEmployeeResponse;
import com.tavant.service.wsdl.UpdateEmployeeRequest;
import com.tavant.service.wsdl.UpdateEmployeeResponse;

@Component
public class EmployeeClient extends WebServiceGatewaySupport  {	
		
	private static final String EMP_URL="https://employeeservice.herokuapp.com/ws";
	
	
	public GetEmployeeResponse getEmployeeById(int empId) {		
		GetEmployeeRequest request = new GetEmployeeRequest();
		request.setEmpId(empId);
		GetEmployeeResponse response = (GetEmployeeResponse) getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(EMP_URL));
		return response;
	}
	
	public SaveEmployeeResponse saveEmployee(Employee employee) {		
		SaveEmployeeRequest request = new SaveEmployeeRequest();
		request.setEmployee(employee);
		SaveEmployeeResponse response = (SaveEmployeeResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback(EMP_URL));
		return response;
	}
	
	public UpdateEmployeeResponse updateEmployee(Employee employee) {		
		UpdateEmployeeRequest request = new UpdateEmployeeRequest();
		request.setEmployee(employee);
		UpdateEmployeeResponse response = (UpdateEmployeeResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback(EMP_URL));
		return response;
	}
	
	public  ListAllEmployeeResponse getAllEmployee() {
		ListAllEmployeeRequest request = new ListAllEmployeeRequest();
		ListAllEmployeeResponse response = (ListAllEmployeeResponse) getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(EMP_URL));
		return response;
	}
	
	public String deleteEmployee(int empId) {		
		DeleteEmployeeRequest request = new DeleteEmployeeRequest();
		request.setEmpId(empId);
		getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(EMP_URL));
		return "Employee deleted sucessfully. ";
	}
}
