package com.bank.demo.metier;

import java.util.List;

import com.bank.demo.entities.Employe;

public interface EmployeMetier {

	public Employe save(Employe employe);
	public List<Employe> employes();
}
