package com.mowil.ats.entities;
// Generated 11 juin 2020 17:08:47 by Hibernate Tools 5.4.14.Final

import java.util.Collection;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Role implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -977536984687630261L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRole;
	private String libelle;
	@OneToMany(mappedBy= "role")
	private Collection<Utilisateur> utilisateurs;
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Collection<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	

}
