package com.mowil.ats.entities;
// Generated 11 juin 2020 17:08:47 by Hibernate Tools 5.4.14.Final

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

public class Ville implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7730345386584545464L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVille;
	@ManyToOne
	private Departement departement;
	private String libelle;
	private String codePostal;
	@OneToMany(mappedBy = "ville")
	private Collection<Utilisateur> utilisateurs;
	@OneToMany(mappedBy = "ville")
	private Collection<Addresse> addresses;
	public Ville() {
		super();
	}
	public Ville(Long idVille, Departement departement, String libelle, String codePostal,
			Collection<Utilisateur> utilisateurs, Collection<Addresse> addresses) {
		super();
		this.idVille = idVille;
		this.departement = departement;
		this.libelle = libelle;
		this.codePostal = codePostal;
		this.utilisateurs = utilisateurs;
		this.addresses = addresses;
	}
	public Long getIdVille() {
		return idVille;
	}
	public void setIdVille(Long idVille) {
		this.idVille = idVille;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public Collection<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	public Collection<Addresse> getAddresses() {
		return addresses;
	}
	public void setAddresses(Collection<Addresse> addresses) {
		this.addresses = addresses;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
