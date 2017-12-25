package com.bank.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.demo.entities.Employe;
import com.bank.demo.metier.EmployeMetier;

@RestController
public class EmployeRestService {

	@Autowired
	private EmployeMetier employeMetier;

	@RequestMapping(value="/employes",method=RequestMethod.POST)
	public Employe save(@RequestBody Employe employe) {
		return employeMetier.save(employe);
	}
	@RequestMapping(value="/employes",method=RequestMethod.GET)
	public List<Employe> employes() {
		return employeMetier.employes();
	}
}
