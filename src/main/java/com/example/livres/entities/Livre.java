package com.example.livres.entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Livre {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLivre;
	private String titre,auteur;
	private int nbPages;
	private Date dateParution;
	@ManyToOne(cascade = CascadeType.ALL)
	private TypeLivre type;
	

	public Livre(String titre, String auteur, int nbPages, Date dateParution) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.nbPages = nbPages;
		this.dateParution = dateParution;
	}
	public Livre(String titre, String auteur, int nbPages, Date dateParution, TypeLivre type) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.nbPages = nbPages;
		this.dateParution = dateParution;
		this.type = type;
	}

	public Long getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(Long idLivre) {
		this.idLivre = idLivre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public int getNbPages() {
		return nbPages;
	}

	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}

	public Date getDateParution() {
		return dateParution;
	}

	public void setDateParution(Date dateParution) {
		this.dateParution = dateParution;
	}
	
	@Override
	public String toString() {
		return "Produit [idLivre=" + idLivre + ", titreLivre=" + titre + ", nbPages=" + nbPages
				+ ", dateParution=" + dateParution + "]";
	}
}
