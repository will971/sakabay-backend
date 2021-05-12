package com.mowil.ats;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mowil.ats.configuration.PropsConfiguration;
import com.mowil.ats.dao.entities.Compte;
import com.mowil.ats.dao.entities.Departement;
import com.mowil.ats.dao.entities.Role;
import com.mowil.ats.dao.entities.Utilisateur;
import com.mowil.ats.dao.entities.Ville;
import com.mowil.ats.dao.repositories.CompteRepository;
import com.mowil.ats.dao.repositories.DepartementRepository;
import com.mowil.ats.dao.repositories.RoleRepository;
import com.mowil.ats.dao.repositories.UtilisateurRepository;
import com.mowil.ats.dao.repositories.VilleRepository;
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

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		Calendar cal = new GregorianCalendar();

		Departement dep1 = new Departement();
		dep1.setLibelle("Guadeloupe");
		dep1.setCode("971");

		Ville ville1 = new Ville();
		ville1.setLibelle("Basse-Terre");
		ville1.setCodePostal("97100");
		ville1.setDepartement(dep1);

		Ville ville2 = new Ville();
		ville2.setLibelle("Petit bourg");
		ville2.setDepartement(dep1);
		ville2.setCodePostal("97170");

		Role role1 = new Role("USER");

		roleRepository.save(role1);

		Role role2 = new Role("ADMIN");
		roleRepository.save(role2);

		Role role3 = new Role("PROFFESSIONNEL");
		roleRepository.save(role3);

		depRepository.save(dep1);
		villeRepository.save(ville1);
		villeRepository.save(ville2);

		Compte c1 = new Compte();
		Utilisateur utilisateur1 = new Utilisateur();

		c1.setDateDeNaissance(cal.getTime());
		c1.setMail("modeste.william.s@gmail.com");
		c1.setPassword(passwordEncoder.encode("will"));
		c1.setUsername("Will");
		ArrayList<Role> listRoles = new ArrayList<>();
		listRoles.add(role1);
		listRoles.add(role2);
		listRoles.add(role3);

		c1.setRoles(new HashSet<>(listRoles));
		compteRepository.save(c1);

		utilisateur1.setPrenom("Will");
		utilisateur1.setNom("MODESTE");
		utilisateur1.setTelephone("0778430873");
		utilisateur1.setCompte(c1);
		utilisateurRepository.save(utilisateur1);
		loggerService.infoLog(LOG, this.props.env.getProperty("test"));

	}

}
