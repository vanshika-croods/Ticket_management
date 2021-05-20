package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.CustomerVO;
import com.example.demo.model.TicketVO;

public interface TicketService {
	
	public TicketVO insert(TicketVO ticketVO);
	
	public List<TicketVO> findAll();
	
	public void deleteTicket(long id);
	
	public TicketVO findById(long id);
	

	Optional<TicketVO> editTicket(long ticketId);


}
