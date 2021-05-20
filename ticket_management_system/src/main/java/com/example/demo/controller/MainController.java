package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.TicketVO;
import com.example.demo.service.TicketService;

@Controller
public class MainController {
	
	@Autowired
	private TicketService ticketService;

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
	
	
	
}
