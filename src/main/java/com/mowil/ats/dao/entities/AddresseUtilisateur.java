package com.mowil.ats.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AddresseUtilisateur implements java.io.Serializable {

	private static final long serialVersionUID = -1237565009519875750L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_ville", nullable = false)
	private Ville ville;
	@Column()
	private String numeroRue;
	@Column()
	private String nomRue;
	@Column()
	private String complementAddresse;
	@ManyToOne()
	@JoinColumn(name = "id_utilisateur", nullable = false)
	private Utilisateur utilisateur;

	public AddresseUtilisateur() {
		super();
	}

	public AddresseUtilisateur(Long id, Ville ville, String numeroRue, String nomRue, String complementAddresse,
			Utilisateur utilisateur) {
		super();
		this.id = id;
		this.ville = ville;
		this.numeroRue = numeroRue;
		this.nomRue = nomRue;
		this.complementAddresse = complementAddresse;
		this.utilisateur = utilisateur;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public String getNumeroRue() {
		return numeroRue;
	}

	public void setNumeroRue(String numeroRue) {
		this.numeroRue = numeroRue;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public String getComplementAddresse() {
		return complementAddresse;
	}

	public void setComplementAddresse(String complementAddresse) {
		this.complementAddresse = complementAddresse;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
