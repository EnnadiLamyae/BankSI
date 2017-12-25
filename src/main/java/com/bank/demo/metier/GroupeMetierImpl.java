package com.bank.demo.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.demo.entities.Groupe;
import com.bank.demo.repositories.GroupeRepository;

@Service
public class GroupeMetierImpl implements GroupeMetier{

	@Autowired
	private GroupeRepository groupeRepository;
	@Override
	public Groupe save(Groupe groupe) {
		// TODO Auto-generated method stub
		return groupeRepository.save(groupe);
	}

	@Override
	public List<Groupe> groupes() {
		// TODO Auto-generated method stub
		return groupeRepository.findAll();
	}

}
