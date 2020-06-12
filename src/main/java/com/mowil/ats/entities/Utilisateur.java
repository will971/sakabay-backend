package com.mowil.ats.entities;
// Generated 11 juin 2020 17:08:47 by Hibernate Tools 5.4.14.Final

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 28505912489606516L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateur;
	@ManyToOne
	private Role role;
	@ManyToOne
	private Ville ville;
	private String mail;
	private String mdp;
	private Date dateNaissance;
	private String telephone;
	private String nom;
	private String prenom;
	private Byte statut;
	private String numeroRue;
	private String nomRue;
	private String complementAddress;
	@OneToMany(mappedBy = "utilisateur")
	private Collection<Rdv> rdvs;

}
