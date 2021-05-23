package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.StudentVO;
import com.example.demo.repo.StudentRepo;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	public void insertStudent(StudentVO studentVO) {
		studentRepo.save(studentVO);
	}

}
