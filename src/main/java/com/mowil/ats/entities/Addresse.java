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
public class Addresse implements java.io.Serializable {

	private static final long serialVersionUID = -1237565009519875750L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAddresse;
	@ManyToOne
	private Ville ville;
	private String numeroRue;
	private String nomRue;
	private String complementAddresse;
	@OneToMany(mappedBy = "addresse")
	private Collection<Rdv> rdvs;
	@OneToMany(mappedBy = "addresse")
	private Collection<Professionnel> professionnels;

}
