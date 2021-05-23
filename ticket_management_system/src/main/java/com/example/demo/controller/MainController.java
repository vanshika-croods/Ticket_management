package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Registration;
import com.example.demo.model.TicketVO;
import com.example.demo.repo.registerServiceRepo;
import com.example.demo.service.TicketService;
import com.example.demo.service.registerService;

@Controller
public class MainController {
	
	@Autowired
	private TicketService ticketService;

	@Autowired
	private registerService regService;
	
	@GetMapping(value = {"","/"})
	public ModelAndView customer() {
		return new ModelAndView("index");
	}
	
	@GetMapping("addsupport")
	public ModelAndView addsupport() {
		return new ModelAndView("addSupport");
	}
	
	@GetMapping("/viewsupport")
	public ModelAndView viewSupport() {
			return new ModelAndView("viewSupport");
	}
	
	/**
	 * view page of ticket
	 * @param ticketId
	 * @return
	 */
	@GetMapping("/listsupport/{ticketId}")
	public ModelAndView listsupport(@PathVariable long ticketId) {
		TicketVO ticketdetails = ticketService.findById(ticketId);
		return new ModelAndView("listSupport").addObject("ticketdetails",ticketdetails);
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/editsupport")
	public ModelAndView editsupport() {
		return new ModelAndView("editSupport");
	}
	
	@GetMapping("/student")
	public ModelAndView studentForm() {
		return new ModelAndView("student");
	}
	
	@GetMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("student");
	}
	
	@PostMapping("/saveregister")
	public ModelAndView saveRegister(@ModelAttribute Registration register) {
		regService.insert(register);
		System.out.println("inserted");
		return new ModelAndView("redirect:/student");
	}
	
}
