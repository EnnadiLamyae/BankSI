package com.bank.demo.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.demo.entities.Compte;
import com.bank.demo.metier.CompteMetier;
import com.bank.demo.metier.OperationMetier;
import com.bank.demo.metier.PageOperation;

@Component
@WebService
public class BankSaopService {

	@Autowired
	private CompteMetier compteMetier;

	@Autowired
	private OperationMetier operationMetier;
	
	@WebMethod
	public Compte compte(@WebParam(name="code") String code) {
		return compteMetier.compte(code);
	}
	@WebMethod
	public boolean verser(@WebParam(name="codeEmploye") Long codeEmploye, 
			@WebParam(name="code") String code, 
			@WebParam(name="montant") double montant) {
		return operationMetier.verser(codeEmploye, code, montant);
	}
	@WebMethod
	public boolean retirer(@WebParam(name="codeEmploye") Long codeEmploye, 
			@WebParam(name="code") String code, 
			@WebParam(name="montant") double montant) {
		return operationMetier.retirer(codeEmploye, code, montant);
	}
	@WebMethod
	public boolean virement(@WebParam(name="codeEmploye") Long codeEmploye, 
			@WebParam(name="code1") String code1, 
			@WebParam(name="code2") String code2, 
			@WebParam(name="montant") double montant) {
		return operationMetier.virement(codeEmploye, code1, code2, montant);
	}
	@WebMethod
	public PageOperation operations(@WebParam(name="code") String code,
			@WebParam(name="page") int page,
			@WebParam(name="size") int size) {
		return operationMetier.operations(code, page, size);
	}
}
