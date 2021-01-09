package com.mowil.ats.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mowil.ats.dao.repositories.CompteRepository;
import com.mowil.ats.dao.repositories.DepartementRepository;
import com.mowil.ats.dao.repositories.RoleRepository;
import com.mowil.ats.dao.repositories.UtilisateurRepository;
import com.mowil.ats.dao.repositories.VilleRepository;

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

}
