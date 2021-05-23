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
@Table(name="student_table")

public class StudentVO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="student_id")
	private long studentId;
	
	@Column(name="student_firstname")
	private String firstName;
	
	@Column(name="student_lastname")
	private String lastName;
	
	@Column(name="student_email")
	private String email;
	
	@Column(name="student_password")
	private String password;
	
	
	
}
