package com.neuresys.formation.java8.streamjpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neuresys.formation.java8.streamjpa.component.EmployeProcessor;
import com.neuresys.formation.java8.streamjpa.model.Employe;


@RestController
public class EmployeController {

	@Autowired 
	EmployeProcessor employeProcessor;
	
	/*
	 *   /employees?email=<email de l'employe>
	 *   /employees
	 */
	 @GetMapping("/employees")
	 @ResponseBody
	 List<Employe> filterByEmail(@RequestParam  Optional<String> email) {
	   if (email.isPresent())
		 return employeProcessor.processEmploye(email.get());
	   else return employeProcessor.findAllEmploye();
	  }
}
