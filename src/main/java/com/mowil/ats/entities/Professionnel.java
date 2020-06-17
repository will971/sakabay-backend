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

public class Professionnel implements java.io.Serializable {

	private static final long serialVersionUID = 1884176178522937422L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProfessionnel;
	@ManyToOne
	private Addresse addresse;
	private String nom;
	private String prenom;
	private String mail;
	private String telephone;
	private Byte statut;
	@OneToMany(mappedBy = "professionnel")
	private Collection<Rdv> rdvs;
	@OneToMany(mappedBy = "professionnel")
	private Collection<ServiceProfessionnel> serviceProfessionnels;
	public Professionnel() {
		super();
	}
	public Professionnel(Long idProfessionnel, Addresse addresse, String nom, String prenom, String mail,
			String telephone, Byte statut, Collection<Rdv> rdvs,
			Collection<ServiceProfessionnel> serviceProfessionnels) {
		super();
		this.idProfessionnel = idProfessionnel;
		this.addresse = addresse;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.telephone = telephone;
		this.statut = statut;
		this.rdvs = rdvs;
		this.serviceProfessionnels = serviceProfessionnels;
	}
	public Long getIdProfessionnel() {
		return idProfessionnel;
	}
	public void setIdProfessionnel(Long idProfessionnel) {
		this.idProfessionnel = idProfessionnel;
	}
	public Addresse getAddresse() {
		return addresse;
	}
	public void setAddresse(Addresse addresse) {
		this.addresse = addresse;
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
	public Byte getStatut() {
		return statut;
	}
	public void setStatut(Byte statut) {
		this.statut = statut;
	}
	public Collection<Rdv> getRdvs() {
		return rdvs;
	}
	public void setRdvs(Collection<Rdv> rdvs) {
		this.rdvs = rdvs;
	}
	public Collection<ServiceProfessionnel> getServiceProfessionnels() {
		return serviceProfessionnels;
	}
	public void setServiceProfessionnels(Collection<ServiceProfessionnel> serviceProfessionnels) {
		this.serviceProfessionnels = serviceProfessionnels;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
