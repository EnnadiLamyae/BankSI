package com.bank.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.demo.entities.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {

}
