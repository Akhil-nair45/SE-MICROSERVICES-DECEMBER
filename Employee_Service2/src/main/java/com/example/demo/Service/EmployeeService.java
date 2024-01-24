package com.example.demo.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Employee;
import com.example.demo.FeignUtil.AddressFeign;
import com.example.demo.Repository.EmployeeRepo;
import com.example.demo.Request.EmployeeResquest;
import com.example.demo.Response.AddressResponse;
import com.example.demo.Response.EmployeeResponse;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo er;
	
	@Autowired
	private ModelMapper mp;
	
	@Autowired
	private AddressFeign af;
	
//	@Autowired
//	private RestTemplate rt;
	
	
	public EmployeeResponse getEmployeeById(int id)
	{
		
//		here we are converting or we dont want the entity to get exposed directly 
//		so we r now exposing response here as we have changed in controller we r changing things in the service layer as well
//		employee -> employeeREsponse
		Employee employee = er.findById(id).get();
		
//		we r implementing modelmapper
		EmployeeResponse er = mp.map(employee, EmployeeResponse.class);
		
		
//		now as we want to see the data of address so as we are returning the er
//		we need to get the data of ar as well se first create ar object 
//		and then er.setAddressResponse(ar); and then return er it will show the data
//		AddressResponse addressResponse = new AddressResponse();
		
//		now we need to get the data se we use rest template call
//		take 3 parameter so 1 is url of address where we want the data, in url set {id} at last as we will get the data what we enter in the service here its int id so, 2 response we want address response so write addressresponse.class, 3 urivariables that is id )
//		AddressResponse addressResponse = rt.getForObject("http://localhost:8081/address-app/api/address/{id}", AddressResponse.class, id);
//		er.setAddressResponse(addressResponse);
		
		
//		now we r implementing feign-client so below is the code
//		AddressResponse ar = null;     //if we set null in postman it will see null like this[{"id":2,"name":"Harshil","email":"Ha@12.com","bloodgroup":"AB+ve","addressResponse":null}], if we wan to show the values u have to create a obj as showin in below line
		
//		AddressResponse ar = new AddressResponse();  
//		er.setAddressResponse(ar);  //here u r setting this is er and then returning er so it will give data without values in postman, if u want data u have to use rest/feign/webclient
//this type of data will come if u do above 2 line of code
//		{
//		    "id": 2,
//		    "name": "Harshil",
//		    "email": "Ha@12.com",
//		    "bloodgroup": "AB+ve",
//		    "addressResponse": {   //here u can see whole body is coming 
//		        "id": 0,
//		        "lane1": null,
//		        "lane2": null,
//		        "state": null,
//		        "zip": null
//		    }
//		}
		
//		now using feign, first u have to add so go to project and left click and go to spring and add starters easy u can add dependency
		AddressResponse ar = af.getAddressByEmpId(id).getBody();  //here we have to write .getbody() bcoz we have written return type as responseEntity in the controller of address / in address feign if return type would have been only address response then . getbody() wont be used and also in address feign the only thing is end point which truly mattera and it is not compulsory to copy paste the same method u can make ur method but focus on endpoint it should be same like the same way selenium exoress did in ep-3 watch between 29-33 minute
		er.setAddressResponse(ar);
		
		
//		so u can see both above and below, above we have just one line to convert or map things unlike below were we have to manually get and set data 
		
		
		
//		here we r setting the data into response from entity and then returning the response one
		
//		EmployeeResponse er= new EmployeeResponse();
//		er.setId(employee.getId());
//		er.setName(employee.getName());
//		er.setEmail(employee.getEmail());
//		er.setBloodgroup(employee.getBloodgroup());
//		we commended the above lines as we r using modelmapper
		return er;
	}
	
	
	public EmployeeResponse saveEmployee(EmployeeResquest employeeResquest) {
	    // employeeRequest --> map to employee
	    Employee employee = mp.map(employeeResquest, Employee.class);
	    // calling method to save
	    Employee savedEmployee = er.save(employee);
	    // savedEmployee --> map to employeeRequest
	    EmployeeResponse savedEmployeeRequest = mp.map(savedEmployee, EmployeeResponse.class);
	    return savedEmployeeRequest;
	}
	
	
	
//	u
//	public EmployeeResponse getAllEmloyee()
//	{
//		List<Employee> findAll = er.findAll();
//		EmployeeResponse map = mp.map(findAll, EmployeeResponse.class);
//		
//	}
}
