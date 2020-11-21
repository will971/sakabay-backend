package com.mowil.ats.model.dto;

public class AddresseUtilisateurDTO {

	private long id;
	private VilleDTO ville;
	private String numeroRue;
	private String nomRue;
	private String compplementAddresse;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public VilleDTO getVille() {
		return ville;
	}

	public void setVille(VilleDTO ville) {
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

	public String getCompplementAddresse() {
		return compplementAddresse;
	}

	public void setCompplementAddresse(String compplementAddresse) {
		this.compplementAddresse = compplementAddresse;
	}

}
