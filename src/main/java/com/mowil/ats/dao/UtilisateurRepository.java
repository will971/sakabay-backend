package com.mowil.ats.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mowil.ats.entities.Utilisateur;

@RepositoryRestResource
public interface UtilisateurRepository extends JpaRepository< Utilisateur,Long> {

	@Query(" select u from Utilisateur u " +
            " where u.mail = ?1")
	public Optional<Utilisateur> findUserByUsername(String username);
}
