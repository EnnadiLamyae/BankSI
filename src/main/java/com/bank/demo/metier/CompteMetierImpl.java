package com.bank.demo.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.demo.entities.Compte;
import com.bank.demo.repositories.CompteRepository;

@Service
public class CompteMetierImpl implements CompteMetier{

	@Autowired
	private CompteRepository compteRepository;
	
	@Override
	public Compte save(Compte compte) {
		compte.setDateCreation(new Date());
		return compteRepository.save(compte);
	}

	@Override
	public List<Compte> comptes() {
		return compteRepository.findAll();
	}

	@Override
	public Compte compte(String code) {
		return compteRepository.findOne(code);
	}

}
