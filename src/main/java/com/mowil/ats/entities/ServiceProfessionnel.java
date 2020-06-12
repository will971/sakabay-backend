package com.mowil.ats.entities;

import java.util.Collection;

import javax.persistence.Entity;
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
public class ServiceProfessionnel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5882109104071170676L;
	@Id
	private Long id;
	@ManyToOne
	private Professionnel professionnel;
	@ManyToOne
	private Service service;
	private String descripton;
	private Float montant;
	private Integer duree;
	private Byte surPlace;
	private Byte deplacement;
	private Byte statut;
	@OneToMany(mappedBy = "serviceProfessionnel")
	private Collection<RdvServiceProfessionnel> rdvServicesProfessionnels;

}
