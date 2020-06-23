package com.mowil.ats.entities;
// Generated 11 juin 2020 17:08:47 by Hibernate Tools 5.4.14.Final

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

public class Utilisateur implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 28505912489606516L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateur;
	@Column(unique = true, nullable = false)
	private String username;
	@ManyToOne
	private Role role;
	@ManyToOne
	private Ville ville;
	@Column(unique = true, nullable = false)
	private String mail;
	@Column(nullable = false)
	private String mdp;
	@Column(nullable = false)
	private Date dateNaissance;
	private String telephone;
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	private boolean statut;
	@Column(nullable = false)
	private String numeroRue;
	@Column(nullable = false)
	private String nomRue;
	@Column(nullable = true)
	private String complementAddress;
	@OneToMany(mappedBy = "utilisateur")
	private Collection<Rdv> rdvs;
	public Utilisateur() {
		super();
	}
	
	public Utilisateur(Long idUtilisateur, String username, Role role, Ville ville, String mail, String mdp,
			Date dateNaissance, String telephone, String nom, String prenom, boolean statut, String numeroRue,
			String nomRue, String complementAddress, Collection<Rdv> rdvs) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.username = username;
		this.role = role;
		this.ville = ville;
		this.mail = mail;
		this.mdp = mdp;
		this.dateNaissance = dateNaissance;
		this.telephone = telephone;
		this.nom = nom;
		this.prenom = prenom;
		this.statut = statut;
		this.numeroRue = numeroRue;
		this.nomRue = nomRue;
		this.complementAddress = complementAddress;
		this.rdvs = rdvs;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
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
	public boolean getStatut() {
		return statut;
	}
	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	public String getNumeroRue() {
		return numeroRue;
	}
	public void setNumeroRue(String numeroRue) {
		this.numeroRue = numeroRue;
	}
	public String getNomRue() {
		return nomRue;
	}
	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}
	public String getComplementAddress() {
		return complementAddress;
	}
	public void setComplementAddress(String complementAddress) {
		this.complementAddress = complementAddress;
	}
	public Collection<Rdv> getRdvs() {
		return rdvs;
	}
	public void setRdvs(Collection<Rdv> rdvs) {
		this.rdvs = rdvs;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	
}
