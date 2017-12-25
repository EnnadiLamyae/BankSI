package com.bank.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.demo.metier.OperationMetier;
import com.bank.demo.metier.PageOperation;

@RestController
public class OperationRestService {

	@Autowired
	private OperationMetier operationMetier;

	@RequestMapping(value="/versement",method=RequestMethod.PUT)
	public boolean verser(@RequestParam Long codeEmploye, @RequestParam String code, @RequestParam double montant) {
		return operationMetier.verser(codeEmploye, code, montant);
	}

	@RequestMapping(value="/retrait",method=RequestMethod.PUT)
	public boolean retirer(@RequestParam Long codeEmploye, @RequestParam String code, @RequestParam double montant) {
		return operationMetier.retirer(codeEmploye, code, montant);
	}
	@RequestMapping(value="/virement",method=RequestMethod.PUT)
	public boolean virement(@RequestParam Long codeEmploye, @RequestParam String code1, @RequestParam String code2, @RequestParam double montant) {
		return operationMetier.virement(codeEmploye, code1, code2, montant);
	}
	
	@RequestMapping(value="/operations",method=RequestMethod.GET)
	public PageOperation operations(@RequestParam String code, @RequestParam int page, @RequestParam int size) {
		return operationMetier.operations(code, page, size);
	}
}
