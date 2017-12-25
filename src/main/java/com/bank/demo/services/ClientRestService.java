package com.bank.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.demo.entities.Client;
import com.bank.demo.metier.ClientMetier;

@RestController
public class ClientRestService {

	@Autowired
	private ClientMetier clientMetier;

	@RequestMapping(value="/clients",method=RequestMethod.POST)
	public Client save(@RequestBody Client client) {
		return clientMetier.save(client);
	}
	
	@RequestMapping(value="/clients",method=RequestMethod.GET)
	public List<Client> clients() {
		return clientMetier.clients();
	}
	
	@RequestMapping(value="/clients/{code}",method=RequestMethod.GET)
	public Client client(@PathVariable Long code) {
		return clientMetier.client(code);
	}
}
