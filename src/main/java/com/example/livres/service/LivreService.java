package com.example.livres.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.livres.entities.Livre;




public interface LivreService {

	Livre saveLivre(Livre l);
	Livre updateLivre(Livre l);
	void deleteLivre(Livre l);
	void deleteLivreById(Long id);
	Livre getLivre(Long id);
	List<Livre> getAllLivres();
	Page<Livre> getAllLivresParPage(int page, int size);
}
