package com.mowil.ats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mowil.ats.configuration.JwtTokenUtil;

@RestController
@CrossOrigin
public class currentUserController {
	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@RequestMapping(value="/api/jwtDecode", method=RequestMethod.GET)
	private ResponseEntity<?> jwtDecode(@RequestHeader (name="Authorization") String token){
		
		return ResponseEntity.ok(jwtTokenUtil.getAllClaimsFromToken(token.substring(7)));
	}
}
