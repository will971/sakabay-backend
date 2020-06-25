package com.mowil.ats.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AllUserDetailsService implements UserDetailsService {

	@Autowired
	private UtilisateurDetailsService userDetailsService;
	@Autowired
	private ProfessionnelDetailsService profDetailsService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserDetails user; 
		try {
			// Tentative de trouver un utilisateur
			user =userDetailsService.loadUserByUsername(username);
		} catch (Exception e) {
			// Tentative de trouver un professionnel
			user = profDetailsService.loadUserByUsername(username);
		}
	
		return user;
	}

}
