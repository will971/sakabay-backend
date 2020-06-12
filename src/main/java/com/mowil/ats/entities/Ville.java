package com.mowil.ats.entities;
// Generated 11 juin 2020 17:08:47 by Hibernate Tools 5.4.14.Final

import java.util.Collection;

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
	private String libelle;
	private String codePostal;
	@OneToMany(mappedBy = "ville")
	private Collection<Utilisateur> utilisateurs;
	@OneToMany(mappedBy = "ville")
	private Collection<Addresse> addresses;

}
