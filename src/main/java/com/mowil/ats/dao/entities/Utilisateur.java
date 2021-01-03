package com.mowil.ats.dao.entities;
// Generated 11 juin 2020 17:08:47 by Hibernate Tools 5.4.14.Final

import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity

public class Utilisateur implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 28505912489606516L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column
	private String telephone;
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	@OneToOne(mappedBy = "utilisateur")
	private Compte compte;
	@OneToMany(mappedBy = "utilisateur")
	private Set<AddresseUtilisateur> addresses;
	@ManyToMany()
	@JoinTable(name = "Services_Utilisateurs", joinColumns = @JoinColumn(name = "utilisateur_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
	private Collection<Service> services;

	public Utilisateur() {
		super();
	}

	public Utilisateur(Long id, String telephone, String nom, String prenom, Compte compte,
			Set<AddresseUtilisateur> addresses, Set<Service> services) {
		super();
		this.id = id;
		this.telephone = telephone;
		this.nom = nom;
		this.prenom = prenom;
		this.compte = compte;
		this.addresses = addresses;
		this.services = services;
	}

	public Collection<Service> getServices() {
		return services;
	}

	public void setServices(Collection<Service> services) {
		this.services = services;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Set<AddresseUtilisateur> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<AddresseUtilisateur> addresses) {
		this.addresses = addresses;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
