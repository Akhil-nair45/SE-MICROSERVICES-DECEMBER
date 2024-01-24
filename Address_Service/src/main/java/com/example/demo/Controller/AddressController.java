package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Response.AddressResponse;
import com.example.demo.Service.AddressService;

@RestController
//@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService as;

	@GetMapping("/address/{employeeId}")
	public ResponseEntity<AddressResponse> getAddressByEmpId(@PathVariable("employeeId") int id)
	{
		AddressResponse ar= null;
		AddressResponse findAddressByEid = as.findEmployeeByEid(id);
		return ResponseEntity.status(HttpStatus.OK).body(findAddressByEid);
	}
	
	@GetMapping("address/All")
	public ResponseEntity<List<AddressResponse>> getAllAddress()
	{
//		AddressResponse ar= new AddressResponse();
		List<AddressResponse> findAlladdress = as.findAll();
		return ResponseEntity.status(HttpStatus.FOUND).body(findAlladdress);
		
		
	}
	
}
