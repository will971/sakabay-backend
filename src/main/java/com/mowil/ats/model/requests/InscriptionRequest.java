package com.mowil.ats.model.requests;

import java.io.Serializable;

import com.mowil.ats.model.beans.AdresseUtilisateurBean;
import com.mowil.ats.model.beans.CompteBean;
import com.mowil.ats.model.beans.DepartementBean;
import com.mowil.ats.model.beans.UtilisateurBean;
import com.mowil.ats.model.beans.VilleBean;

public class InscriptionRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5009184057970990072L;

	private CompteBean compte;
	private UtilisateurBean utilisateur;
	private DepartementBean departement;
	private VilleBean ville;
	private AdresseUtilisateurBean adresseUtilisateur;

	public DepartementBean getDepartement() {
		return departement;
	}

	public void setDepartement(DepartementBean departement) {
		this.departement = departement;
	}

	public VilleBean getVille() {
		return ville;
	}

	public void setVille(VilleBean ville) {
		this.ville = ville;
	}

	public AdresseUtilisateurBean getAdresseUtilisateur() {
		return adresseUtilisateur;
	}

	public void setAdresseUtilisateur(AdresseUtilisateurBean adresseUtilisateur) {
		this.adresseUtilisateur = adresseUtilisateur;
	}

	public UtilisateurBean getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(UtilisateurBean utilisateur) {
		this.utilisateur = utilisateur;
	}

	public CompteBean getCompte() {
		return compte;
	}

	public void setCompte(CompteBean compte) {
		this.compte = compte;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
