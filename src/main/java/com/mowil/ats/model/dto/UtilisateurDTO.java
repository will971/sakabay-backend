package com.mowil.ats.model.dto;

public class UtilisateurDTO {

	private long id;
	private String nom;
	private String prenom;
	private String telephone;
	private AddresseUtilisateurDTO addresses;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public AddresseUtilisateurDTO getAddresses() {
		return addresses;
	}

	public void setAddresses(AddresseUtilisateurDTO addresses) {
		this.addresses = addresses;
	}

}
