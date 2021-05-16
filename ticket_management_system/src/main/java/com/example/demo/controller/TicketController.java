package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.helper.fileupload;
import com.example.demo.model.CustomerVO;
import com.example.demo.model.TicketVO;
import com.example.demo.repo.TicketRepo;
import com.example.demo.service.CustomerService;
import com.example.demo.service.TicketService;

@Controller
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private fileupload fileupload;

	@Autowired
	private TicketRepo ticketRepo;
	
	@PostMapping("/saveTicket")
	public ModelAndView saveTicket(@RequestParam("file") MultipartFile file,@ModelAttribute TicketVO ticketVO) throws Exception{
		
		//file upload code here
		if(file.isEmpty()) {
			throw new Exception("file not found exception");
		}

		//file upload here
		try {
			boolean f = fileupload.uploadfile(file);
			if(f) {
				System.out.println("file successfully uploaded");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");  
	    String strDate= formatter.format(date); 
	    ticketVO.setTicketDate(strDate);
	    ticketService.insert(ticketVO);
	    System.out.println("ticket inserted in database");
		return new ModelAndView("redirect:/viewSupport");
				
	}
	
	@ResponseBody
	@RequestMapping(value = "/data/users", method = RequestMethod.POST)
	public DataTablesOutput<TicketVO> getUsers(@Valid @RequestBody DataTablesInput input) {
	    return ticketRepo.findAll(input);
	  }
	
	@GetMapping("/viewSupport")
	public ModelAndView viewSupport() {
		List<CustomerVO> customerVO = customerService.findall();
		return new ModelAndView("viewSupport").addObject("customerVO",customerVO);
	}
	
}
