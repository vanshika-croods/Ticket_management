package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name="ticket_tbl")
public class TicketVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name="ticket_id")
	private long ticketId;
	
	@Column(name="ticket_date")
	private String ticketDate;
	
	@Column(name="ticket_title")
	private String ticketTitle;
	
	@ManyToOne
	@JoinColumn(name="customer_id", referencedColumnName = "customer_id")
	private CustomerVO customerVO;
    
    @Column(name="ticket_description")
	private String ticketDescription;
	
	
}
