package com.mowil.ats.dao.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Compte implements Serializable {

	private static final long serialVersionUID = -7488551097263455198L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(unique = true, nullable = false)
	private String mail;
	@Column(unique = true, nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private Date dateDeNaissance;
	@Column(nullable = false)
	private boolean status;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "Compte_Utilisateur", joinColumns = {
			@JoinColumn(name = "compte_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "utilisateur_id", referencedColumnName = "id") })
	private Utilisateur utilisateur;

	@ManyToMany()
	@JoinTable(name = "Comptes_Roles", joinColumns = @JoinColumn(name = "compte_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> roles;

	public Compte() {
		super();
	}

	public Compte(Long id, String mail, String username, String password, Date dateDeNaissance, boolean status,
			Utilisateur utilisateur, Set<Role> roles) {
		super();
		this.id = id;
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.dateDeNaissance = dateDeNaissance;
		this.status = status;
		this.utilisateur = utilisateur;

		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
