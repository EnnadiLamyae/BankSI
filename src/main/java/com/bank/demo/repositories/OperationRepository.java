package com.bank.demo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bank.demo.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{

	@Query("SELECT o FROM Operation o  WHERE o.compte.codeCompte=:x")
	public Page<Operation> operations(@Param("x") String code , Pageable pageable);
}
