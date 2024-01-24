package com.example.demo.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeAppConfig {

	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

//	@Bean
//	public RestTemplate restTemplate()
//	{
//		return new RestTemplate();
//	}
//	
//	@Bean
//	public FeignClient fiegnClient()
//	{
//		return new Feign
//	}
}
