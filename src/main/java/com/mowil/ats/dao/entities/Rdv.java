package com.mowil.ats.dao.entities;
// Generated 11 juin 2020 17:08:47 by Hibernate Tools 5.4.14.Final

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Rdv implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3092691325286737733L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRdv;

	@ManyToOne
	private Utilisateur utilisateur;
	@Column(nullable = false)
	private Date dateDebut;
	@Column(nullable = true)
	private Date dateFin;

	public Rdv() {
		super();
	}

	public Rdv(Long idRdv, Utilisateur utilisateur, Date dateDebut, Date dateFin) {
		super();
		this.idRdv = idRdv;
		this.utilisateur = utilisateur;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public Long getIdRdv() {
		return idRdv;
	}

	public void setIdRdv(Long idRdv) {
		this.idRdv = idRdv;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
