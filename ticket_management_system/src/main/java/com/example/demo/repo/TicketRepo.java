package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CustomerVO;
import com.example.demo.model.TicketVO;

@Repository
public interface TicketRepo extends JpaRepository<TicketVO, Long> ,DataTablesRepository<TicketVO, Long>{

	@Query(value = "select * from ticket_tbl where ticket_id = ?1 ",nativeQuery = true)
	TicketVO findByTicket_id(long ticketId);
	
}
