package com.bank.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.demo.entities.Compte;
import com.bank.demo.metier.CompteMetier;

@RestController
public class CompteRestService {

	@Autowired
	private CompteMetier compteMetier;
	
	@RequestMapping(value="/comptes",method=RequestMethod.POST)
	public Compte save(@RequestBody Compte compte) {
		return compteMetier.save(compte);
	}
	
	@RequestMapping(value="/comptes",method=RequestMethod.GET)
	public List<Compte> comptes() {
		return compteMetier.comptes();
	}
	
	@RequestMapping(value="/comptes/{code}",method=RequestMethod.GET)
	public Compte compte(@PathVariable String code) {
		return compteMetier.compte(code);
	}
	
}
