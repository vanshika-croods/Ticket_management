package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CustomerVO;
import com.example.demo.repo.CustomerRepo;

@Service
@Transactional

public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public List<CustomerVO> findall() {
		// TODO Auto-generated method stub
		return this.customerRepo.findAll();
	}

	@Override
	public CustomerVO insertCustomer(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		return this.customerRepo.save(customerVO);
	}
	
}
