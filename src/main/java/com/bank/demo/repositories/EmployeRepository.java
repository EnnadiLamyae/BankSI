package com.bank.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.demo.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe,Long> {

}
