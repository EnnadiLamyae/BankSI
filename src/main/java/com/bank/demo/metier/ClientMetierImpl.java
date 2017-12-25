package com.bank.demo.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.demo.entities.Client;
import com.bank.demo.repositories.ClientRepository;

@Service
public class ClientMetierImpl  implements ClientMetier{

	@Autowired
	private ClientRepository clientRepository;
	@Override
	public Client save(Client client) {
		// TODO Auto-generated method stub
		return clientRepository.save(client);
	}

	@Override
	public List<Client> clients() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public Client client(Long code) {
		// TODO Auto-generated method stub
		return clientRepository.findOne(code);
	}

	
}
