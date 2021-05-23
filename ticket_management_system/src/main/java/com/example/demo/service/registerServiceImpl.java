package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Registration;
import com.example.demo.repo.registerServiceRepo;

@Service
@Transactional
public class registerServiceImpl implements registerService {

	@Autowired
	private registerServiceRepo regRepo;

	@Override
	public void insert(Registration register) {
		regRepo.save(register);
	}
	
	
}
