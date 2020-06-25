package com.mowil.ats.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mowil.ats.dao.ProfessionnelRepository;
import com.mowil.ats.entities.Professionnel;
@Service
public class ProfessionnelDetailsService implements UserDetailsService {
	@Autowired
	private ProfessionnelRepository professionnelRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("je suis passé dans professionnel");
		Professionnel pro = this.professionnelRepository.findProfessionnelByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("user not found"));
		System.out.println("je suis passé dans professionnel");
		return new User(pro.getMail(), pro.getMdp(), new ArrayList<>());
	}
}
