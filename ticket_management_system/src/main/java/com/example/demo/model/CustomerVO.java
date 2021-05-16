package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer_tbl")
public class CustomerVO {
	
	public CustomerVO(String custromerName, String customerMobNo, String customerEmail) {
		super();
		this.custromerName = custromerName;
		this.customerMobNo = customerMobNo;
		this.customerEmail = customerEmail;
	}

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int customer_id;
	
	@Column(name="customer_name")
	private String custromerName;
	
	@Column(name="customer_mobno")
	private String customerMobNo;
	
	@Column(name="customer_email")
	private String customerEmail;
	
	@Column(name="customer_dob")
	private String dateOfBirth;
	
}
