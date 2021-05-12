package com.mowil.ats.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mowil.ats.dao.entities.Compte;
import com.mowil.ats.dao.entities.Departement;
import com.mowil.ats.dao.entities.Role;
import com.mowil.ats.dao.entities.Ville;
import com.mowil.ats.dao.repositories.CompteRepository;
import com.mowil.ats.dao.repositories.DepartementRepository;
import com.mowil.ats.dao.repositories.RoleRepository;
import com.mowil.ats.dao.repositories.UtilisateurRepository;
import com.mowil.ats.dao.repositories.VilleRepository;
import com.mowil.ats.model.beans.CompteBean;
import com.mowil.ats.model.beans.DepartementBean;
import com.mowil.ats.model.beans.RoleBean;
import com.mowil.ats.model.beans.VilleBean;
import com.mowil.ats.model.requests.InscriptionRequest;

@Service
public class InscriptionService {
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private RoleRepository rolerepository;
    @Autowired
    private VilleRepository villeRepository;
    @Autowired
    private DepartementRepository departementRepository;
    @Autowired
    private MappingService mappingService;
    @Autowired
    private CheckDataService checkDataService;

    /**
     * Méthode qui permet de s'inscrire
     */
    public void inscription(InscriptionRequest inscriptionRequest) {
	// Récupération et affectation des roles au compte
	List<Role> roles = getRoles(inscriptionRequest.getRoleBeans());
	// creation du compte
	Compte c = createCompte(inscriptionRequest.getCompte(), roles);
	// Récupération et affectation de la ville et du département
	try {
	    Ville ville = getOrCreateVille(inscriptionRequest.getVille(), inscriptionRequest.getDepartement());
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	// Vérification que l'utilisateur n'existe pas en base & creation de

    }

    public List<Role> getRoles(List<RoleBean> roleBeans) {
	List<Role> roles = new ArrayList<Role>();
	for (RoleBean roleBean : roleBeans) {
	    if (checkDataService.checkRoleData(roleBean)) {
		Optional<Role> optionalrole = rolerepository.findOneByLibelle(roleBean.getLibelle());
		if (optionalrole.isPresent()) {
		    roles.add(optionalrole.get());
		}
	    } else {
		// TODO LOG warning car les info sont incomplète
	    }
	}
	return roles;
    }

    private Departement getOrCreateDepartement(DepartementBean departementBean) throws Exception {
	if (checkDataService.checkDepartementData(departementBean)) {
	    Departement departement;
	    if (departementRepository.findOneByLibelle(departementBean.getLibelle()).isPresent()) {
		departement = departementRepository.findOneByLibelle(departementBean.getLibelle()).get();
	    } else {
		departement = mappingService.departementMapping(departementBean);
		departement = departementRepository.save(departement);
	    }
	    return departement;
	} else {
	    throw new Exception("Les données du département sont incomplètes");
	}
    }

    public Ville getOrCreateVille(VilleBean villeBean, DepartementBean departementBean) throws Exception {

	if (checkDataService.checkVilleData(villeBean)) {
	    Ville ville;
	    if (villeRepository.findOneByLibelle(villeBean.getLibelle()).isPresent()) {
		ville = villeRepository.findOneByLibelle(villeBean.getLibelle()).get();
	    } else {
		Departement departement = getOrCreateDepartement(departementBean);
		ville = mappingService.villeMapping(villeBean);
		ville.setDepartement(departement);
		ville = villeRepository.save(ville);
	    }
	    return ville;
	} else {
	    throw new Exception("Les données de la ville sont incomplètes");
	}

    }

    public Compte createCompte(CompteBean compteB, List<Role> roles) {
	Compte c = null;
	if (checkDataService.checkCompteData(compteB)) {
	    c = this.compteRepository.save(mappingService.compteMapping(compteB, roles));
	} else {
	    // TODO LOG warning car les info sont incomplètes
	}
	return c;
    }

}
