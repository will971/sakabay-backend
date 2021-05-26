package com.mowil.ats;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.SpringDocUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mowil.ats.configuration.PropsConfiguration;
import com.mowil.ats.dao.entities.Role;
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
import com.mowil.ats.services.InscriptionService;
import com.mowil.ats.services.LoggerService;

@SpringBootApplication
public class SakabayBackendApplication implements CommandLineRunner {
    @Autowired
    private DepartementRepository depRepository;
    @Autowired
    private VilleRepository villeRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private PropsConfiguration props;
    @Autowired
    private LoggerService loggerService;
    @Autowired
    private InscriptionService inscriptionService;
    private static final Logger LOG = LoggerFactory.getLogger(SakabayBackendApplication.class);

    public static void main(String[] args) {
	SpringApplication.run(SakabayBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
	SpringDocUtils.getConfig().replaceWithClass(org.springframework.data.domain.Pageable.class,
		org.springdoc.core.converters.models.Pageable.class);

	Role role1 = new Role("USER");

	roleRepository.save(role1);

	Role role2 = new Role("ADMIN");
	roleRepository.save(role2);

	Role role3 = new Role("PROFFESSIONNEL");
	roleRepository.save(role3);

	inscriptionService.inscription(setData());

	loggerService.infoLog(LOG, this.props.env.getProperty("test"));

    }

    public InscriptionRequest setData() {
	// initialisation du calendar
	var cal = new GregorianCalendar();
	// initialisation de l'objet de requête d'inscription
	var inscriptionRequest = new InscriptionRequest();
	// initialisation du compte et de ses données
	var compteB = new CompteBean();
	compteB.setDateOfBirth(cal.getTime());
	compteB.setMail("modeste.william.s@gmail.com");
	compteB.setPassword("will");
	compteB.setUsername("Will");
	// initialisation de l'adresse utilisateur et de ses données
	var adresseUtilisateurBean = new AdresseUtilisateurBean();
	adresseUtilisateurBean.setComplementAddresse("appartement 10");
	adresseUtilisateurBean.setNomRue("rue henry descamps");
	adresseUtilisateurBean.setNumeroRue("21");
	// initialisation du département et de ses données
	var departementBean = new DepartementBean();
	departementBean.setLibelle("Guadeloupe");
	departementBean.setCode("971");
	// initialisation de l'utilisateur et de ses données
	var utilisateurBean = new UtilisateurBean();
	utilisateurBean.setPrenom("Will");
	utilisateurBean.setNom("MODESTE");
	utilisateurBean.setTelephone("0778430873");
	// initialisation de la ville et de ses données
	var villeBean = new VilleBean();
	villeBean.setLibelle("Basse-Terre");
	villeBean.setCodePostal("97100");

	ArrayList<RoleBean> roleBeans = new ArrayList<>();
	var roleBean = new RoleBean();
	roleBean.setLibelle("ADMIN");
	roleBeans.add(roleBean);

	inscriptionRequest.setRoleBeans(roleBeans);
	inscriptionRequest.setVille(villeBean);
	inscriptionRequest.setUtilisateur(utilisateurBean);
	inscriptionRequest.setDepartement(departementBean);
	inscriptionRequest.setAdresseUtilisateur(adresseUtilisateurBean);
	inscriptionRequest.setCompte(compteB);

	return inscriptionRequest;

    }

}
