package com.mowil.ats.model.beans;

public class RoleBean {
	private Long id;
	private String libelle;

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

	public RoleBean(Long id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

	public RoleBean(String libelle) {
		super();
		this.libelle = libelle;
	}

}
