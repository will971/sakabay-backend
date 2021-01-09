package com.mowil.ats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mowil.ats.model.requests.InscriptionRequest;
import com.mowil.ats.services.InscriptionService;

@RestController
@CrossOrigin
public class CompteController {
	@Autowired
	private InscriptionService inscriptionService;

	@PostMapping(value = "/signup")
	public ResponseEntity<?> inscription(@RequestBody InscriptionRequest request) {
		return null;

	}

}
