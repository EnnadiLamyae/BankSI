package com.bank.demo.metier;

import java.util.List;

import com.bank.demo.entities.Groupe;

public interface GroupeMetier {

	public Groupe save(Groupe groupe);
	public List<Groupe> groupes();
}
