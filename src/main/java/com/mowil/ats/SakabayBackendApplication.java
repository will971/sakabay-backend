package com.mowil.ats;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mowil.ats.dao.DepartementRepository;
import com.mowil.ats.dao.RoleRepository;
import com.mowil.ats.dao.UtilisateurRepository;
import com.mowil.ats.dao.VilleRepository;
import com.mowil.ats.entities.Departement;
import com.mowil.ats.entities.Role;
import com.mowil.ats.entities.Utilisateur;
import com.mowil.ats.entities.Ville;

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
		Role role1 = new Role();
		role1.setLibelle("USER");
		Role role2 = new Role();
		role2.setLibelle("Admin");
		roleRepository.save(role1);
		roleRepository.save(role2);

		depRepository.save(dep1);
		villeRepository.save(ville1);
		villeRepository.save(ville2);

		Utilisateur utilisateur1 = new Utilisateur();
		utilisateur1.setMail("modeste.william.s@gmail.com");
		utilisateur1.setMdp(passwordEncoder.encode("will"));
		utilisateur1.setNom("MODESTE");
		utilisateur1.setPrenom("Will");
		utilisateur1.setDateNaissance(cal.getTime());
		utilisateur1.setComplementAddress("owa fanm aw");
		utilisateur1.setRole(role1);
		utilisateur1.setVille(ville1);
		utilisateur1.setTelephone("0778430873");
		utilisateur1.setNumeroRue("01");
		utilisateur1.setNomRue("Boulevard gerty archimède");
		utilisateur1.setStatut(true);
		utilisateurRepository.save(utilisateur1);

		Utilisateur utilisateur2 = new Utilisateur();
		utilisateur2.setMail("jock@email.com");
		utilisateur2.setMdp(passwordEncoder.encode("darmajock"));
		utilisateur2.setNom("Darmalingon");
		utilisateur2.setPrenom("Joachim");
		utilisateur2.setDateNaissance(cal.getTime());
		utilisateur2.setComplementAddress("an ba boule ay");
		utilisateur2.setRole(role2);
		utilisateur2.setVille(ville2);
		utilisateur2.setTelephone("000000000");
		utilisateur2.setNumeroRue("69");
		utilisateur2.setNomRue("owa blanc la");
		utilisateur2.setStatut(true);
		utilisateurRepository.save(utilisateur2);

	}

}
