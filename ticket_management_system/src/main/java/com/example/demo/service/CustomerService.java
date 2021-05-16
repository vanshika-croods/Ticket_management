package com.example.demo.service;

import java.util.List;

import com.example.demo.model.CustomerVO;

public interface CustomerService {
	
	public CustomerVO insertCustomer(CustomerVO customerVO);
	
	public List<CustomerVO> findall();
}
