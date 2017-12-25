package com.bank.demo.rmi;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.demo.entities.Compte;
import com.bank.demo.metier.CompteMetier;
import com.bank.demo.metier.OperationMetier;

@Component("RMIService")
public class BankRMIImpl implements BankRMI{
	
	@Autowired
	private CompteMetier compteMetier;
	@Autowired
	private OperationMetier operationMetier;

	@Override
	public Compte createCompte(Compte compte) throws RemoteException {
		return compteMetier.save(compte);
	}

	@Override
	public Compte consultCompte(String code) throws RemoteException {
		return compteMetier.compte(code);
	}

	@Override
	public boolean verser(Long codeEmploye, String code, double montant) throws RemoteException {
		return operationMetier.verser(codeEmploye, code, montant);
	}

	@Override
	public boolean retirer(Long codeEmploye, String code, double montant) throws RemoteException {
		return operationMetier.retirer(codeEmploye, code, montant);
	}

	@Override
	public boolean virement(Long codeEmploye, String code1, String code2, double montant) throws RemoteException {
		return operationMetier.virement(codeEmploye, code1, code2, montant);
	}

}
