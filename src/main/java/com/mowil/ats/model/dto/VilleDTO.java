package com.mowil.ats.model.dto;

public class VilleDTO {

	private long id;
	private String libelle;
	private DepartementDTO departement;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public DepartementDTO getDepartement() {
		return departement;
	}

	public void setDepartement(DepartementDTO departement) {
		this.departement = departement;
	}

}
