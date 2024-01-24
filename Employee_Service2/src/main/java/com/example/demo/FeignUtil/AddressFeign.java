package com.example.demo.FeignUtil;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Response.AddressResponse;

@FeignClient(name = "Address-feign",url = "http://localhost:8081/address-app/api/")
public interface AddressFeign {

	
	@GetMapping("/address/{employeeId}")
	public ResponseEntity<AddressResponse> getAddressByEmpId(@PathVariable("employeeId") int id);
	
}
