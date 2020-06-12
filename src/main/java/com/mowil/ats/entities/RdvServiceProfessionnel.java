package com.mowil.ats.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class RdvServiceProfessionnel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1535303340265574200L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private ServiceProfessionnel serviceProfessionnel;
	@ManyToOne
	private Rdv rdv;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ServiceProfessionnel getServiceProfessionnel() {
		return serviceProfessionnel;
	}
	public void setServiceProfessionnel(ServiceProfessionnel serviceProfessionnel) {
		this.serviceProfessionnel = serviceProfessionnel;
	}
	public Rdv getRdv() {
		return rdv;
	}
	public void setRdv(Rdv rdv) {
		this.rdv = rdv;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}