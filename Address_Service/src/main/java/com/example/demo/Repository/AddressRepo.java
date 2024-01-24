package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

//	address based on a empId we r writing a query
	@Query(nativeQuery = true,value = "SELECT ea.id,ea.lane1,ea.lane2,ea.state,ea.zip FROM semicroservicesdecember.address ea join semicroservicesdecember.employee e on e.id = ea.employee_id where ea.employee_id=:employeeId")
	Address findAddressByEmployeeId(@Param("employeeId") int employeeId);
}
