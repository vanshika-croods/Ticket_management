package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.StudentVO;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/student/save")
	public ModelAndView student(@ModelAttribute StudentVO studentVO) {
		studentService.insertStudent(studentVO);
		System.out.println("data saved");
		return new ModelAndView("student");
	}
}
