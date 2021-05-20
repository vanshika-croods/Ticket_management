package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CustomerVO;
import com.example.demo.model.TicketVO;
import com.example.demo.repo.TicketRepo;

@Service
@Transactional

public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepo ticketRepo;
	
	@Override
	public TicketVO insert(TicketVO ticketVO) {
		// TODO Auto-generated method stub
		return ticketRepo.save(ticketVO);
	}

	@Override
	public List<TicketVO> findAll() {
		// TODO Auto-generated method stub
		return ticketRepo.findAll();
	}

	@Override
	public void deleteTicket(long id) {
		// TODO Auto-generated method stub
		this.ticketRepo.deleteById(id);
	}

	@Override
	public TicketVO findById(long id) {
		// TODO Auto-generated method stub
		return ticketRepo.findByTicket_id(id);
	}

	
	@Override
	public Optional<TicketVO> editTicket(long ticketId) {
		// TODO Auto-generated method stub
		return ticketRepo.findById(ticketId);
	}

	
}
