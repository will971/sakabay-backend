package com.mowil.ats.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mowil.ats.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository< Utilisateur,Long> {

}
