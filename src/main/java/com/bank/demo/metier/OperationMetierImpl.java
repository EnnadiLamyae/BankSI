package com.bank.demo.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.demo.entities.Compte;
import com.bank.demo.entities.Employe;
import com.bank.demo.entities.Operation;
import com.bank.demo.entities.Retrait;
import com.bank.demo.entities.Versement;
import com.bank.demo.repositories.CompteRepository;
import com.bank.demo.repositories.EmployeRepository;
import com.bank.demo.repositories.OperationRepository;

@Service
public class OperationMetierImpl implements OperationMetier {

	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private EmployeRepository employeRepository;

	@Override
	@Transactional
	public boolean verser(Long codeEmploye, String code, double montant) {
		Employe employe = employeRepository.findOne(codeEmploye);
		Compte compte = compteRepository.findOne(code);
		Operation versement= new Versement();
		versement.setDateOperation(new Date());
		versement.setCompte(compte);
		versement.setEmploye(employe);
		versement.setMontant(montant);
		operationRepository.save(versement);
		compte.setSolde(compte.getSolde()+montant);
		return true;
	}

	@Override
	@Transactional
	public boolean retirer(Long codeEmploye, String code, double montant) {
		Compte compte = compteRepository.findOne(code);
		if(compte.getSolde()<montant) throw new RuntimeException("Solde insuffisant");
		Employe employe = employeRepository.findOne(codeEmploye);
		Operation versement= new Retrait();
		versement.setDateOperation(new Date());
		versement.setCompte(compte);
		versement.setEmploye(employe);
		versement.setMontant(montant);
		operationRepository.save(versement);
		compte.setSolde(compte.getSolde()-montant);
		return true;
	}

	@Override
	@Transactional
	public boolean virement(Long codeEmploye, String code1, String code2, double montant) {
		retirer(codeEmploye, code1, montant);
		verser(codeEmploye, code2, montant);
		return true;
	}

	@Override
	public PageOperation operations(String code, int page, int size) {

		Page<Operation> operationsParPage = operationRepository.operations(code, new PageRequest(page, size));
		PageOperation pageOperation = new PageOperation();
		pageOperation.setOperations(operationsParPage.getContent());
		pageOperation.setNombreOperations(operationsParPage.getNumberOfElements());
		pageOperation.setPage(operationsParPage.getNumber());
		pageOperation.setNombrePages(operationsParPage.getTotalPages());
		pageOperation.setTotal((int)operationsParPage.getTotalElements());
		return pageOperation;
	}
	

}
