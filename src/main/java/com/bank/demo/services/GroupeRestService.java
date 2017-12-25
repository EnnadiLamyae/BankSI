package com.bank.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.demo.entities.Groupe;
import com.bank.demo.metier.GroupeMetier;

@RestController
public class GroupeRestService {

	@Autowired
	private GroupeMetier groupeMetier;

	@RequestMapping(value="/groupes",method=RequestMethod.POST)
	public Groupe save(@RequestBody Groupe groupe) {
		return groupeMetier.save(groupe);
	}
	@RequestMapping(value="/groupes",method=RequestMethod.GET)
	public List<Groupe> groupes() {
		return groupeMetier.groupes();
	}
}
