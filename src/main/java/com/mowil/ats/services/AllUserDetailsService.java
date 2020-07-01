package com.mowil.ats.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mowil.ats.dao.entities.Compte;
import com.mowil.ats.dao.entities.Role;
import com.mowil.ats.dao.repositories.CompteRepository;

@Service
public class AllUserDetailsService implements UserDetailsService {

	@Autowired
	private CompteRepository compteRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Compte c = compteRepository.findOneByMailOrUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("user not found"));

		User user = new User(c.getMail(), c.getPassword(), new ArrayList<>());

		return user;
	}

}
