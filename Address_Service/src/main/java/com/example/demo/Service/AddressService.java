package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Address;
import com.example.demo.Repository.AddressRepo;
import com.example.demo.Response.AddressResponse;

@Service
public class AddressService {

	@Autowired
	private AddressRepo ar;
	
	@Autowired
	private ModelMapper mp;
	
	public AddressResponse findEmployeeByEid(int employeeId)
	{
		Address address = ar.findAddressByEmployeeId(employeeId);
		
//		impl modelmapper
		AddressResponse map = mp.map(address, AddressResponse.class);
		return map;
	}
	
	public List<AddressResponse> findAll() {
		List<Address> add = ar.findAll();
		System.out.println(add);
		List<AddressResponse> userResponses = add.stream().map(address -> mp.map(address, AddressResponse.class))
				.collect(Collectors.toList());
		System.out.println(userResponses);
 
		return userResponses;
}
	
	
}
