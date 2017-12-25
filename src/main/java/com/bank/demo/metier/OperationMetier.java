package com.bank.demo.metier;

public interface OperationMetier {

	public boolean verser(Long codeEmploye , String code , double montant);
	public boolean retirer(Long codeEmploye , String code , double montant);
	public boolean virement(Long codeEmploye , String code1 , String code2 , double montant);
	public PageOperation operations(String code , int page , int size);
}
