package com.laudo.apilaudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laudo.apilaudo.models.Montadora;

public interface MontadoraRepository extends JpaRepository<Montadora, Long> {
	
	Montadora findById(long id);
	
}
