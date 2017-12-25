package com.bank.demo.metier;

import java.util.List;

import com.bank.demo.entities.Compte;

public interface CompteMetier {

	public Compte save(Compte compte);
	public Compte compte(String code);
	public List<Compte> comptes();
}
