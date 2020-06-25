package com.mowil.ats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mowil.ats.configuration.JwtTokenUtil;
import com.mowil.ats.model.JwtRequest;
import com.mowil.ats.model.JwtResponse;
import com.mowil.ats.services.ProfessionnelDetailsService;
import com.mowil.ats.services.UtilisateurDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private UtilisateurDetailsService userDetailsService;
	@Autowired
	ProfessionnelDetailsService professionnelDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest, String type)
			throws Exception {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		if (type.equals("user")) {

			final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
			final String token = jwtTokenUtil.generateToken(userDetails, type);
			return ResponseEntity.ok(new JwtResponse(token));
		} else if (type.equals("pro")) {
			final UserDetails professionnelDetails = professionnelDetailsService
					.loadUserByUsername(authenticationRequest.getUsername());
			final String token = jwtTokenUtil.generateToken(professionnelDetails, type);
			return ResponseEntity.ok(new JwtResponse(token));
		}
		else {
			throw new Exception();
		}
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}