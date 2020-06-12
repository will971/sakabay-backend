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

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rdv implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3092691325286737733L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRdv;
	@ManyToOne
	private Addresse addresse;
	@ManyToOne
	private Professionnel professionnel;
	@ManyToOne
	private Utilisateur utilisateur;
	private Date dateDebut;
	private Date dateFin;
	@OneToMany(mappedBy = "rdv")
	private Collection<RdvServiceProfessionnel> rdvServiceProfessionnels;

}
