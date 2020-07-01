package com.mowil.ats.dao.entities;
// Generated 11 juin 2020 17:08:47 by Hibernate Tools 5.4.14.Final

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

public class Service implements java.io.Serializable {

	private static final long serialVersionUID = 972537843908118737L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idService;
	@ManyToOne
	private Profession profession;
	private String libelle;
	@OneToMany(mappedBy = "service")
	private Collection<ServiceProfessionnel> serviceProfessionnels;

	public Service() {
		super();
	}

	public Service(Long idService, Profession profession, String libelle,
			Collection<ServiceProfessionnel> serviceProfessionnels) {
		super();
		this.idService = idService;
		this.profession = profession;
		this.libelle = libelle;
		this.serviceProfessionnels = serviceProfessionnels;
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
