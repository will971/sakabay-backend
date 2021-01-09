package com.mowil.ats.model.beans;

import java.io.Serializable;

public class DepartementBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4120931052029427790L;
	private Long id;
	private String libelle;
	private String code;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public DepartementBean(String libelle, String code) {
		super();
		this.libelle = libelle;
		this.code = code;
	}

	public DepartementBean(Long id, String libelle, String code) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.code = code;
	}

}
