package com.bank.demo.metier;

import java.util.List;

import com.bank.demo.entities.Client;

public interface ClientMetier {

	public Client save(Client client);
	public Client client(Long code);
	public List<Client> clients();
}
