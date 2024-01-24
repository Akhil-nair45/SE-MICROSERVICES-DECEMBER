package com.example.demo.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
	
	private int id;
	private String name;
	private String email;
	private String bloodgroup;
	
//	now we want the data of address also so we have to copy paste the address response
	private AddressResponse addressResponse;
}
