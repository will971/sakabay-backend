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
public class Profession implements java.io.Serializable {

	private static final long serialVersionUID = 2990885856557639610L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProfession;
	private String libelle;
	private String description;
	@OneToMany(mappedBy = "profession")
	private Collection<Service> services;

}
