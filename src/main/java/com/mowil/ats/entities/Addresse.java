package com.mowil.ats.entities;
// Generated 11 juin 2020 17:08:47 by Hibernate Tools 5.4.14.Final

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Addresse implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1237565009519875750L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAddresse;
	@ManyToOne
	private Ville ville;
	private String numeroRue;
	private String nomRue;
	private String complementAddresse;
	@OneToMany(mappedBy="addresse")
	private Collection<Rdv> rdvs;
	@OneToMany(mappedBy="addresse")
	private Collection<Professionnel> professionnels;
	public Long getIdAddresse() {
		return idAddresse;
	}
	public void setIdAddresse(Long idAddresse) {
		this.idAddresse = idAddresse;
	}
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	public String getNumeroRue() {
		return numeroRue;
	}
	public void setNumeroRue(String numeroRue) {
		this.numeroRue = numeroRue;
	}
	public String getNomRue() {
		return nomRue;
	}
	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}
	public String getComplementAddresse() {
		return complementAddresse;
	}
	public void setComplementAddresse(String complementAddresse) {
		this.complementAddresse = complementAddresse;
	}
	public Collection<Rdv> getRdvs() {
		return rdvs;
	}
	public void setRdvs(Collection<Rdv> rdvs) {
		this.rdvs = rdvs;
	}
	public Collection<Professionnel> getProfessionnels() {
		return professionnels;
	}
	public void setProfessionnels(Collection<Professionnel> professionnels) {
		this.professionnels = professionnels;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
