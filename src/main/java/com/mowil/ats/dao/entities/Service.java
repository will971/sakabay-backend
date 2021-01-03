package com.mowil.ats.dao.entities;
// Generated 11 juin 2020 17:08:47 by Hibernate Tools 5.4.14.Final

import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity

public class Service implements java.io.Serializable {

	private static final long serialVersionUID = 972537843908118737L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idService;
	@ManyToOne
	private Profession profession;
	private String libelle;
	@ManyToMany()
	@JoinTable(name = "Services_Utilisateurs", joinColumns = @JoinColumn(name = "service_id"), inverseJoinColumns = @JoinColumn(name = "utilisateur_id"))
	private Collection<Utilisateur> utilisateurs;

	public Service() {
		super();
	}

	public Service(Long idService, Profession profession, String libelle, Set<Utilisateur> utilisateurs) {
		super();
		this.idService = idService;
		this.profession = profession;
		this.libelle = libelle;
		this.utilisateurs = utilisateurs;

	}

	public Collection<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Long getIdService() {
		return idService;
	}

	public void setIdService(Long idService) {
		this.idService = idService;
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
