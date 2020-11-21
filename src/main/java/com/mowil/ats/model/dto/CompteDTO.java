package com.mowil.ats.model.dto;

import java.util.Date;

public class CompteDTO {

	private long id;
	private String username;
	private String mail;
	private Date dateNaissance;
	private UtilisateurDTO utilisateur;
	private ProfessionnelDTO professionnel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public UtilisateurDTO getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(UtilisateurDTO utilisateur) {
		this.utilisateur = utilisateur;
	}

	public ProfessionnelDTO getProfessionnel() {
		return professionnel;
	}

	public void setProfessionnel(ProfessionnelDTO professionnel) {
		this.professionnel = professionnel;
	}

}
