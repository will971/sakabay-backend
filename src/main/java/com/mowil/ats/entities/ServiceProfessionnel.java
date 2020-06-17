package com.mowil.ats.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

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
	public ServiceProfessionnel() {
		super();
	}
	public ServiceProfessionnel(Long id, Professionnel professionnel, Service service, String descripton, Float montant,
			Integer duree, Byte surPlace, Byte deplacement, Byte statut,
			Collection<RdvServiceProfessionnel> rdvServicesProfessionnels) {
		super();
		this.id = id;
		this.professionnel = professionnel;
		this.service = service;
		this.descripton = descripton;
		this.montant = montant;
		this.duree = duree;
		this.surPlace = surPlace;
		this.deplacement = deplacement;
		this.statut = statut;
		this.rdvServicesProfessionnels = rdvServicesProfessionnels;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Professionnel getProfessionnel() {
		return professionnel;
	}
	public void setProfessionnel(Professionnel professionnel) {
		this.professionnel = professionnel;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public String getDescripton() {
		return descripton;
	}
	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}
	public Float getMontant() {
		return montant;
	}
	public void setMontant(Float montant) {
		this.montant = montant;
	}
	public Integer getDuree() {
		return duree;
	}
	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	public Byte getSurPlace() {
		return surPlace;
	}
	public void setSurPlace(Byte surPlace) {
		this.surPlace = surPlace;
	}
	public Byte getDeplacement() {
		return deplacement;
	}
	public void setDeplacement(Byte deplacement) {
		this.deplacement = deplacement;
	}
	public Byte getStatut() {
		return statut;
	}
	public void setStatut(Byte statut) {
		this.statut = statut;
	}
	public Collection<RdvServiceProfessionnel> getRdvServicesProfessionnels() {
		return rdvServicesProfessionnels;
	}
	public void setRdvServicesProfessionnels(Collection<RdvServiceProfessionnel> rdvServicesProfessionnels) {
		this.rdvServicesProfessionnels = rdvServicesProfessionnels;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
