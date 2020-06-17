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
	private Addresse addresse;
	@ManyToOne
	private Professionnel professionnel;
	@ManyToOne
	private Utilisateur utilisateur;
	private Date dateDebut;
	private Date dateFin;
	@OneToMany(mappedBy = "rdv")
	private Collection<RdvServiceProfessionnel> rdvServiceProfessionnels;
	
	public Rdv() {
		super();
	}

	public Rdv(Long idRdv, Addresse addresse, Professionnel professionnel, Utilisateur utilisateur, Date dateDebut,
			Date dateFin, Collection<RdvServiceProfessionnel> rdvServiceProfessionnels) {
		super();
		this.idRdv = idRdv;
		this.addresse = addresse;
		this.professionnel = professionnel;
		this.utilisateur = utilisateur;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.rdvServiceProfessionnels = rdvServiceProfessionnels;
	}

	public Long getIdRdv() {
		return idRdv;
	}

	public void setIdRdv(Long idRdv) {
		this.idRdv = idRdv;
	}

	public Addresse getAddresse() {
		return addresse;
	}

	public void setAddresse(Addresse addresse) {
		this.addresse = addresse;
	}

	public Professionnel getProfessionnel() {
		return professionnel;
	}

	public void setProfessionnel(Professionnel professionnel) {
		this.professionnel = professionnel;
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

	public Collection<RdvServiceProfessionnel> getRdvServiceProfessionnels() {
		return rdvServiceProfessionnels;
	}

	public void setRdvServiceProfessionnels(Collection<RdvServiceProfessionnel> rdvServiceProfessionnels) {
		this.rdvServiceProfessionnels = rdvServiceProfessionnels;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
