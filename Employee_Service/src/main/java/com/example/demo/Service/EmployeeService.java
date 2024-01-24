package com.example.demo.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Entities.Employee;
import com.example.demo.Repository.EmployeeRepo;
import com.example.demo.Response.AddressResponse;
import com.example.demo.Response.EmployeeResponse;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo er;
	
	@Autowired
	private ModelMapper mp;
	
	@Autowired
	private RestTemplate rt;
	
	
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
		AddressResponse addressResponse = rt.getForObject("http://localhost:8081/address-app/api/address/{id}", AddressResponse.class, id);
		er.setAddressResponse(addressResponse);
		

		
		
		
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
}
