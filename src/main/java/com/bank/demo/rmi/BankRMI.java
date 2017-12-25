package com.bank.demo.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.bank.demo.entities.Compte;

public interface BankRMI extends Remote {

	public Compte createCompte(Compte compte) throws RemoteException;
	public Compte consultCompte(String code) throws RemoteException;
	public boolean verser(Long codeEmploye , String code , double montant) throws RemoteException;
	public boolean retirer(Long codeEmploye , String code , double montant) throws RemoteException;
	public boolean virement(Long codeEmploye , String code1 , String code2 , double montant) throws RemoteException;
}
