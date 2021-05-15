package com.mowil.ats.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mowil.ats.configuration.JwtTokenUtil;
import com.mowil.ats.model.requests.InscriptionRequest;
import com.mowil.ats.model.requests.LoginRequest;
import com.mowil.ats.model.responses.JwtResponse;
import com.mowil.ats.services.AllUserDetailsService;
import com.mowil.ats.services.InscriptionService;
import com.mowil.ats.services.LoggerService;

@RestController
@CrossOrigin
public class AuthentificationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AllUserDetailsService userDetailsService;

    @Autowired
    private InscriptionService inscriptionService;
    @Autowired
    private LoggerService logservice;
    private static final Logger LOG = LoggerFactory.getLogger(AuthentificationController.class);

    // Ligne a ajouter devant les points d'entrée sécurisé
    // @Operation(security = {@SecurityRequirement(name = "bearer-key") })

    @PostMapping(value = "/authenticate")
    public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest)
	    throws Exception {
	logservice.debugLog(LOG, "Réception d'une requête d'authentification");
	authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
	final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
	final String token = jwtTokenUtil.generateToken(userDetails);
	logservice.debugLog(LOG, "renvoie du token " + token);
	return ResponseEntity.ok(new JwtResponse(token));
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

    @PostMapping(value = "/signup")
    public ResponseEntity<?> signup(@RequestBody InscriptionRequest inscriptionRequest) {
	logservice.debugLog(LOG, "Inscription d'un nouvel utilisateur : " + inscriptionRequest.toString());
	try {
	    this.inscriptionService.inscription(inscriptionRequest);
	    return ResponseEntity.ok("Inscription réussie");
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return ResponseEntity.badRequest().body("Il y a eu une erreur : " + e.getMessage());
	}

    }
}