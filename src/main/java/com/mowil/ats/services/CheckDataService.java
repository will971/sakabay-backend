package com.mowil.ats.services;

import org.springframework.stereotype.Service;

import com.mowil.ats.model.beans.AdresseUtilisateurBean;
import com.mowil.ats.model.beans.CompteBean;
import com.mowil.ats.model.beans.DepartementBean;
import com.mowil.ats.model.beans.RoleBean;
import com.mowil.ats.model.beans.UtilisateurBean;
import com.mowil.ats.model.beans.VilleBean;

@Service
public class CheckDataService {

    public boolean checkCompteData(CompteBean compteB) {
	boolean dataState = false;
	if (compteB != null) {
	    if (compteB.getMail() != null && !compteB.getMail().isEmpty() && compteB.getUsername() != null
		    && !compteB.getUsername().isEmpty() && compteB.getPassword() != null
		    && !compteB.getPassword().isEmpty() && compteB.getDateOfBirth() != null) {
		dataState = true;
	    } else {
		dataState = false;
	    }

	}
	return dataState;
    }

    public boolean checkVilleData(VilleBean villeBean) {
	boolean isOk = false;
	if (villeBean != null) {
	    isOk = true;
	}
	return isOk;
    }

    public boolean checkRoleData(RoleBean roleBean) {
	boolean isOk = false;
	if (roleBean != null && roleBean.getLibelle() != null && !roleBean.getLibelle().isEmpty()) {
	    isOk = true;
	}
	return isOk;
    }

    public boolean checkDepartementData(DepartementBean departementBean) {
	// TODO faire les checks
	boolean isOk = false;
	if (departementBean != null) {
	    isOk = true;
	}
	return isOk;
    }

    public boolean checkUtilisateurData(UtilisateurBean utilisateurBean) {
	// TODO faire les checks
	boolean isOk = false;
	if (utilisateurBean != null) {
	    isOk = true;
	}
	return isOk;
    }

    public boolean checkAddresseUtilisateurData(AdresseUtilisateurBean adresseUtilisateurBean) {
	// TODO faire les checks
	boolean isOk = false;
	if (adresseUtilisateurBean != null) {
	    isOk = true;
	}
	return isOk;
    }
}
