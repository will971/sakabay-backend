package com.mowil.ats.dao.entities;
// Generated 11 juin 2020 17:08:47 by Hibernate Tools 5.4.14.Final

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Profession implements java.io.Serializable {

	private static final long serialVersionUID = 2990885856557639610L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProfession;
	private String libelle;
	private String description;
	@OneToMany(mappedBy = "profession")
	private Collection<Service> services;
	public Profession() {
		super();
	}
	public Profession(Long idProfession, String libelle, String description, Collection<Service> services) {
		super();
		this.idProfession = idProfession;
		this.libelle = libelle;
		this.description = description;
		this.services = services;
	}
	public Long getIdProfession() {
		return idProfession;
	}
	public void setIdProfession(Long idProfession) {
		this.idProfession = idProfession;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Collection<Service> getServices() {
		return services;
	}
	public void setServices(Collection<Service> services) {
		this.services = services;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
