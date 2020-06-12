package com.mowil.ats.entities;
// Generated 11 juin 2020 17:08:47 by Hibernate Tools 5.4.14.Final

import java.util.Collection;

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
public class Professionnel implements java.io.Serializable {

	private static final long serialVersionUID = 1884176178522937422L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProfessionnel;
	@ManyToOne
	private Addresse addresse;
	private String nom;
	private String prenom;
	private String mail;
	private String telephone;
	private Byte statut;
	@OneToMany(mappedBy = "professionnel")
	private Collection<Rdv> rdvs;
	@OneToMany(mappedBy = "professionnel")
	private Collection<ServiceProfessionnel> serviceProfessionnels;

}
