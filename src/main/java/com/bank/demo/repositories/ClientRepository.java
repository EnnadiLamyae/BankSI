package com.bank.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.demo.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
