package com.mowil.ats.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mowil.ats.dao.entities.AddresseUtilisateur;
import com.mowil.ats.dao.entities.Compte;
import com.mowil.ats.dao.entities.Departement;
import com.mowil.ats.dao.entities.Role;
import com.mowil.ats.dao.entities.Utilisateur;
import com.mowil.ats.dao.entities.Ville;
import com.mowil.ats.model.beans.AdresseUtilisateurBean;
import com.mowil.ats.model.beans.CompteBean;
import com.mowil.ats.model.beans.DepartementBean;
import com.mowil.ats.model.beans.UtilisateurBean;
import com.mowil.ats.model.beans.VilleBean;

@Service
public class MappingService {

    public Ville villeMapping(VilleBean villeBean) {
	Ville ville = new Ville();
	ville.setLibelle(villeBean.getLibelle());
	ville.setCodePostal(villeBean.getCodePostal());
	ville.setDepartement(null);
	return ville;
    }

    public Departement departementMapping(DepartementBean departementBean) {
	Departement d = new Departement();
	d.setCode(departementBean.getCode());
	d.setLibelle(d.getLibelle());
	return d;
    }

    public Compte compteMapping(CompteBean compteB, List<Role> roles) {
	Compte compte = new Compte();
	compte.setDateDeNaissance(compteB.getDateOfBirth());
	compte.setPassword(compteB.getPassword());
	compte.setUsername(compteB.getUsername());
	compte.setMail(compteB.getMail());
	compte.setRoles(roles);
	return compte;

    }

    public Utilisateur utilisateurMapping(UtilisateurBean utilisateurBean) {
	Utilisateur utilisateur = new Utilisateur();
	utilisateur.setNom(utilisateurBean.getNom());
	utilisateur.setPrenom(utilisateurBean.getPrenom());
	utilisateur.setTelephone(utilisateurBean.getTelephone());
	return utilisateur;
    }

    public AddresseUtilisateur adresseUtilisateurMapping(AdresseUtilisateurBean adresseUtilisateurBean, Ville ville,
	    Utilisateur utilisateur) {
	AddresseUtilisateur adresseUtilisateur = new AddresseUtilisateur();
	adresseUtilisateur.setComplementAddresse(adresseUtilisateurBean.getComplementAddresse());
	adresseUtilisateur.setNomRue(adresseUtilisateurBean.getNomRue());
	adresseUtilisateur.setNumeroRue(adresseUtilisateurBean.getNomRue());
	adresseUtilisateur.setVille(ville);
	adresseUtilisateur.setUtilisateur(utilisateur);
	return adresseUtilisateur;
    }
}
