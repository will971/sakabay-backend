package com.mowil.ats.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mowil.ats.dao.entities.AddresseUtilisateur;
import com.mowil.ats.dao.entities.Compte;
import com.mowil.ats.dao.entities.Departement;
import com.mowil.ats.dao.entities.Role;
import com.mowil.ats.dao.entities.Utilisateur;
import com.mowil.ats.dao.entities.Ville;
import com.mowil.ats.dao.repositories.AdresseUtilisateurRepository;
import com.mowil.ats.dao.repositories.CompteRepository;
import com.mowil.ats.dao.repositories.DepartementRepository;
import com.mowil.ats.dao.repositories.RoleRepository;
import com.mowil.ats.dao.repositories.UtilisateurRepository;
import com.mowil.ats.dao.repositories.VilleRepository;
import com.mowil.ats.model.beans.AdresseUtilisateurBean;
import com.mowil.ats.model.beans.CompteBean;
import com.mowil.ats.model.beans.DepartementBean;
import com.mowil.ats.model.beans.RoleBean;
import com.mowil.ats.model.beans.UtilisateurBean;
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
    private AdresseUtilisateurRepository adresseUtilisateurRepository;
    @Autowired
    private MappingService mappingService;
    @Autowired
    private CheckDataService checkDataService;

    /**
     * Méthode qui permet de s'inscrire
     * 
     * @throws Exception
     */
    public void inscription(InscriptionRequest inscriptionRequest) throws Exception {

	// Récupération et affectation des roles au compte
	List<Role> roles = getRoles(inscriptionRequest.getRoleBeans());
	// creation du compte
	var compte = createCompte(inscriptionRequest.getCompte(), roles);
	// Récupération et affectation de la ville et du département
	var ville = getOrCreateVille(inscriptionRequest.getVille(), inscriptionRequest.getDepartement());
	// Vérification que l'utilisateur n'existe pas en base & creation de
	// l'utilisateur
	var utilisateur = checkAndCreateUser(inscriptionRequest.getUtilisateur(), compte);
	checkAndCreateAddresseUtilisateur(inscriptionRequest.getAdresseUtilisateur(), ville, utilisateur);

    }

    private AddresseUtilisateur checkAndCreateAddresseUtilisateur(AdresseUtilisateurBean adresseUtilisateurBean,
	    Ville ville, Utilisateur utilisateur) throws Exception {
	AddresseUtilisateur adresseUtilisateur;
	if (checkDataService.checkAddresseUtilisateurData(adresseUtilisateurBean)) {
	    adresseUtilisateur = mappingService.adresseUtilisateurMapping(adresseUtilisateurBean, ville, utilisateur);
	    adresseUtilisateurRepository.save(adresseUtilisateur);
	} else {
	    throw new Exception("Les données de l'addresse utilisateur sont erronés ou incomplètes");
	}
	return adresseUtilisateur;
    }

    private Utilisateur checkAndCreateUser(UtilisateurBean utilisateurBean, Compte compte) throws Exception {
	Utilisateur utilisateur;
	if (checkDataService.checkUtilisateurData(utilisateurBean)) {
	    utilisateur = mappingService.utilisateurMapping(utilisateurBean);
	    utilisateur.setCompte(compte);
	    Optional<Utilisateur> optionalUser = utilisateurRepository.findOneByCompte(compte);
	    if (!optionalUser.isPresent()) {
		utilisateur = utilisateurRepository.save(utilisateur);
	    } else {
		throw new Exception("Ce compte dispose déjà d'un utilisateur ");
	    }

	} else {
	    throw new Exception("Les données de l'utilisateur sont incomplètes");

	}

	return utilisateur;
    }

    public List<Role> getRoles(List<RoleBean> roleBeans) throws Exception {
	List<Role> roles = new ArrayList<Role>();
	if (roleBeans.isEmpty()) {
	    throw new Exception("La liste de role de la requête est vide");
	}
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
	if (roles.isEmpty()) {
	    throw new Exception("Aucun rôle correspondant n'a été trouvé en base ");
	}
	return roles;
    }

    private Departement getOrCreateDepartement(DepartementBean departementBean) throws Exception {
	if (checkDataService.checkDepartementData(departementBean)) {
	    Departement departement;
	    Optional<Departement> optionalDepartement = departementRepository
		    .findOneByLibelle(departementBean.getLibelle());
	    if (optionalDepartement.isPresent()) {
		departement = optionalDepartement.get();
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
	    Optional<Ville> optionalVille = villeRepository.findOneByLibelle(villeBean.getLibelle());
	    if (optionalVille.isPresent()) {
		ville = optionalVille.get();
	    } else {
		var departement = getOrCreateDepartement(departementBean);
		ville = mappingService.villeMapping(villeBean);
		ville.setDepartement(departement);
		ville = villeRepository.save(ville);
	    }
	    return ville;
	} else {
	    throw new Exception("Les données de la ville sont incomplètes");
	}

    }

    public Compte createCompte(CompteBean compteB, List<Role> roles) throws Exception {
	Compte c = null;
	if (checkDataService.checkCompteData(compteB)) {
	    var passwordEncoder = new BCryptPasswordEncoder();
	    compteB.setPassword(passwordEncoder.encode(compteB.getPassword()));
	    Optional<Compte> optionalCompte = compteRepository.findOneByMailOrUsername(compteB.getMail(),
		    compteB.getUsername());
	    if (!optionalCompte.isPresent()) {
		c = this.compteRepository.save(mappingService.compteMapping(compteB, roles));
	    } else {
		throw new Exception("Il existe déjà un compte avec cette addresse mail ou ce nom d'utilisateur");
	    }

	} else {
	    throw new Exception("Les données du compte sont incomplètes");
	}
	return c;
    }

}
