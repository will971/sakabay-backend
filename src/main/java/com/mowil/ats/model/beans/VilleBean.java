package com.mowil.ats.model.beans;

import java.io.Serializable;

public class VilleBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7093313940770767513L;
	private Long id;
	private String libelle;
	private String codePostal;

	public VilleBean(String libelle, String codePostal) {
		super();
		this.libelle = libelle;
		this.codePostal = codePostal;
	}

	public VilleBean(Long id, String libelle, String codePostal) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.codePostal = codePostal;
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

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

}
