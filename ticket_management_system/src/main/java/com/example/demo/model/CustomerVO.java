package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name="customer_table")
public class CustomerVO {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="customer_id")
	private long customerId;
	
	@Column(name="customer_name")
	private String custromerName;
	
	@Column(name="customer_mobno")
	private String customerMobNo;
	
	@Column(name="customer_email")
	private String customerEmail;
	
	@Column(name="customer_dob")
	private String dateOfBirth;
	
}
