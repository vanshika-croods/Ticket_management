package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.CustomerVO;
import com.example.demo.model.TicketVO;
import com.example.demo.service.CustomerService;


@Controller

public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/viewdetails")
	public List<CustomerVO> viewDetails(){
		List<CustomerVO> detailofcustomer = customerService.findall();
		return detailofcustomer;
	}
	
	
}
