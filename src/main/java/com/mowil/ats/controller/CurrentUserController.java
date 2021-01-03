package com.mowil.ats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.mowil.ats.configuration.JwtTokenUtil;

@RestController
@CrossOrigin
public class CurrentUserController {
	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@PostMapping(value = "/api/jwtDecode")
	public ResponseEntity<?> jwtDecode(@RequestHeader(name = "Authorization") String token) {

		return ResponseEntity.ok(jwtTokenUtil.getAllClaimsFromToken(token.substring(7)));
	}
}
