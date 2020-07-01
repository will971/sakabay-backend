package com.mowil.ats.dao.entities;
// Generated 11 juin 2020 17:08:47 by Hibernate Tools 5.4.14.Final

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity

public class Role implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -977536984687630261L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String libelle;
	@ManyToMany(mappedBy = "roles")
	private Set<Compte> comptes;

	public Role() {
		super();
	}

	public Role(String libelle) {
		super();
		this.libelle = libelle;
	}

	public Role(Long id, String libelle, Set<Compte> comptes) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.comptes = comptes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
