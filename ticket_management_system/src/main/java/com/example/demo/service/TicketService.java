package com.example.demo.service;

import java.util.List;

import com.example.demo.model.TicketVO;

public interface TicketService {
	
	public TicketVO insert(TicketVO ticketVO);
	
	public List<TicketVO> findAll();
}
