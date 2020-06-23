package com.mowil.ats.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mowil.ats.dao.UtilisateurRepository;
import com.mowil.ats.entities.Utilisateur;
@Service
public class UtilisateurDetailsService implements UserDetailsService {
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Utilisateur utilisateurData =this.utilisateurRepository.findUserByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("user not found"));
		 User user = new User(utilisateurData.getUsername(), utilisateurData.getMdp(), new ArrayList<>());
		return user;
	}
}
