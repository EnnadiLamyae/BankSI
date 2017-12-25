package com.bank.demo.metier;

import java.io.Serializable;
import java.util.List;

import com.bank.demo.entities.Operation;

public class PageOperation implements Serializable {

	private List<Operation> operations;
	private int page;
	private int nombreOperations;
	private int total;
	private int nombrePages;
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreOperations() {
		return nombreOperations;
	}
	public void setNombreOperations(int nombreOperations) {
		this.nombreOperations = nombreOperations;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getNombrePages() {
		return nombrePages;
	}
	public void setNombrePages(int nombrePages) {
		this.nombrePages = nombrePages;
	}
	
}
