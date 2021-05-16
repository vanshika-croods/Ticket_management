package com.example.demo.repo;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TicketVO;

public interface TicketRepo extends JpaRepository<TicketVO, Integer>,DataTablesRepository<TicketVO, Integer> {

}
