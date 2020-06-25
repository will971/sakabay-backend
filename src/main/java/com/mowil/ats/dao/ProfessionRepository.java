package com.mowil.ats.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mowil.ats.entities.Profession;

@RepositoryRestResource
public interface ProfessionRepository extends JpaRepository< Profession ,Long>  {

	
}
