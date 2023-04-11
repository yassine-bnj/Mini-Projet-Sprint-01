package com.example.livres.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.livres.entities.Livre;

public interface LivreRepository extends JpaRepository<Livre,Long> {
	
}
