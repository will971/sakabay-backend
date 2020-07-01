package com.mowil.ats.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class AddresseProfessionnel implements java.io.Serializable {

	private static final long serialVersionUID = -1237565009519875750L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="id_ville", nullable=false)
	private Ville ville;
	@Column()
	private String numeroRue;
	@Column(nullable = false)
	private String nomRue;
	@Column()
	private String complementAddresse;

	@ManyToOne()
	private Professionnel professionnel;

	public AddresseProfessionnel() {
		super();
	}

	public AddresseProfessionnel(Long id, Ville ville, String numeroRue, String nomRue, String complementAddresse,
			Professionnel professionnel) {
		super();
		this.id = id;
		this.ville = ville;
		this.numeroRue = numeroRue;
		this.nomRue = nomRue;
		this.complementAddresse = complementAddresse;
		this.professionnel = professionnel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Professionnel getProfessionnel() {
		return professionnel;
	}

	public void setProfessionnel(Professionnel professionnel) {
		this.professionnel = professionnel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
