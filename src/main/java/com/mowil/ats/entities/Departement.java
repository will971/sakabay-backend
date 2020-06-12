package com.mowil.ats.entities;
// Generated 11 juin 2020 17:08:47 by Hibernate Tools 5.4.14.Final

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departement implements java.io.Serializable {

	private static final long serialVersionUID = -7881905642548503795L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDepartement;
	private String libelle;
	private String code;
	@OneToMany(mappedBy = "departement")
	private Collection<Ville> villes;

}
