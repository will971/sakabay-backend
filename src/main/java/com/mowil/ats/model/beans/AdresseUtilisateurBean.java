package com.mowil.ats.model.beans;

import java.io.Serializable;

public class AdresseUtilisateurBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1708280405293038233L;
    private Long id;
    private String numeroRue;
    private String complementAddresse;
    private String nomRue;

    public AdresseUtilisateurBean(Long id, String numeroRue, String complementAddresse, String nomRue) {
	super();
	this.id = id;
	this.numeroRue = numeroRue;
	this.complementAddresse = complementAddresse;
	this.nomRue = nomRue;
    }

    public static long getSerialversionuid() {
	return serialVersionUID;
    }

    public AdresseUtilisateurBean(String numeroRue, String complementAddresse, String nomRue) {
	super();
	this.numeroRue = numeroRue;
	this.complementAddresse = complementAddresse;
	this.nomRue = nomRue;
    }

    public AdresseUtilisateurBean() {
	super();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getNumeroRue() {
	return numeroRue;
    }

    public void setNumeroRue(String numeroRue) {
	this.numeroRue = numeroRue;
    }

    public String getComplementAddresse() {
	return complementAddresse;
    }

    public void setComplementAddresse(String complementAddresse) {
	this.complementAddresse = complementAddresse;
    }

    public String getNomRue() {
	return nomRue;
    }

    public void setNomRue(String nomRue) {
	this.nomRue = nomRue;
    }

}
