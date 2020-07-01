package com.mowil.ats.dao.entities;
// Generated 11 juin 2020 17:08:47 by Hibernate Tools 5.4.14.Final

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity

public class Professionnel implements java.io.Serializable {

	private static final long serialVersionUID = 1884176178522937422L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	@Column(nullable = false, unique = true)
	private String raisonSociale;
	@Column(nullable = false)
	private String mail;
	@Column(nullable = false)
	private String telephone;
	@Column(nullable = false)
	private boolean statut;
	@OneToMany(mappedBy = "professionnel")
	private Set<AddresseProfessionnel> addresses;
	@OneToMany(mappedBy = "professionnel")
	private Set<Rdv> rdvs;
	@OneToMany(mappedBy = "professionnel")
	private Set<ServiceProfessionnel> serviceProfessionnels;
	@OneToOne(mappedBy="professionnel")
	private Compte compte;

	public Professionnel() {
		super();
	}

	public Professionnel(Long id, String nom, String prenom, String raisonSociale, String mail, String telephone,
			Set<AddresseProfessionnel> addresses, Set<Rdv> rdvs, Set<ServiceProfessionnel> serviceProfessionnels) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.raisonSociale = raisonSociale;
		this.mail = mail;
		this.telephone = telephone;
		this.addresses = addresses;
		this.rdvs = rdvs;
		this.serviceProfessionnels = serviceProfessionnels;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public Set<AddresseProfessionnel> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<AddresseProfessionnel> addresses) {
		this.addresses = addresses;
	}

	public Set<Rdv> getRdvs() {
		return rdvs;
	}

	public void setRdvs(Set<Rdv> rdvs) {
		this.rdvs = rdvs;
	}

	public Set<ServiceProfessionnel> getServiceProfessionnels() {
		return serviceProfessionnels;
	}

	public void setServiceProfessionnels(Set<ServiceProfessionnel> serviceProfessionnels) {
		this.serviceProfessionnels = serviceProfessionnels;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	


}
