package com.bank.demo.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.demo.entities.Employe;
import com.bank.demo.repositories.EmployeRepository;

@Service
public class EmployeMetierImpl implements EmployeMetier{

	@Autowired
	private EmployeRepository employeRepository;
	@Override
	public Employe save(Employe employe) {
		// TODO Auto-generated method stub
		return employeRepository.save(employe);
	}

	@Override
	public List<Employe> employes() {
		// TODO Auto-generated method stub
		return employeRepository.findAll();
	}

}
