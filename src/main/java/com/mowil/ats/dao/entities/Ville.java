package com.mowil.ats.dao.entities;
// Generated 11 juin 2020 17:08:47 by Hibernate Tools 5.4.14.Final

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

public class Ville implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7730345386584545464L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVille;
	@ManyToOne
	private Departement departement;
	@Column(unique = true, nullable = false)
	private String libelle;
	@Column(unique = true, nullable = false)
	private String codePostal;

	@OneToMany(mappedBy = "ville")
	private Set<AddresseUtilisateur> addressesUtilisateurs;

	public Ville() {
		super();
	}

	public Ville(Long idVille, Departement departement, String libelle, String codePostal,
			Set<AddresseUtilisateur> addressesUtilisateurs) {
		super();
		this.idVille = idVille;
		this.departement = departement;
		this.libelle = libelle;
		this.codePostal = codePostal;

		this.addressesUtilisateurs = addressesUtilisateurs;
	}

	public Long getIdVille() {
		return idVille;
	}

	public void setIdVille(Long idVille) {
		this.idVille = idVille;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
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

	public Set<AddresseUtilisateur> getAddressesUtilisateurs() {
		return addressesUtilisateurs;
	}

	public void setAddressesUtilisateurs(Set<AddresseUtilisateur> addressesUtilisateurs) {
		this.addressesUtilisateurs = addressesUtilisateurs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
