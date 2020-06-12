package com.mowil.ats.entities;
// Generated 11 juin 2020 17:08:47 by Hibernate Tools 5.4.14.Final

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Departement implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7881905642548503795L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDepartement;
	private String libelle;
	private String code;
	@OneToMany(mappedBy="departement")
	private Collection<Ville> villes ;
	public Long getIdDepartement() {
		return idDepartement;
	}
	public void setIdDepartement(Long idDepartement) {
		this.idDepartement = idDepartement;
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
	public Collection<Ville> getVilles() {
		return villes;
	}
	public void setVilles(Collection<Ville> villes) {
		this.villes = villes;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
