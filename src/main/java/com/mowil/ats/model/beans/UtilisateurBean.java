package com.mowil.ats.model.beans;

import java.io.Serializable;

public class UtilisateurBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3356639076567018364L;
	private Long id;
	private String telephone;
	private String nom;
	private String prenom;

	public UtilisateurBean(String telephone, String nom, String prenom) {
		super();
		this.telephone = telephone;
		this.nom = nom;
		this.prenom = prenom;
	}

	public UtilisateurBean(Long id, String telephone, String nom, String prenom) {
		super();
		this.id = id;
		this.telephone = telephone;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
