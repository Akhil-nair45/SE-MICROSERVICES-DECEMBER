package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Response.EmployeeResponse;
import com.example.demo.Service.EmployeeService;

@RestController
//@RequestMapping("/Employee")
public class EmployeeController {

	@Autowired
	private EmployeeService es;
	
	@GetMapping("/employees/{id}")
	ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id)
	{
//		either u can do it like this or
//		EmployeeResponse employeeById = es.getEmployeeById(id);
//		return ResponseEntity.status(HttpStatus.CREATED).body(employeeById);
		
//		 u can do it like this also
		return new ResponseEntity<>(es.getEmployeeById(id),HttpStatus.CREATED);
	}
}
