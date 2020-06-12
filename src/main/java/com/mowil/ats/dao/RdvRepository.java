package com.mowil.ats.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mowil.ats.entities.Rdv;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RdvRepository extends JpaRepository< Rdv,Long> {

}
