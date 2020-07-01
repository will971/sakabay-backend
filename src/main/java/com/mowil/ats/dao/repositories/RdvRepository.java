package com.mowil.ats.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mowil.ats.dao.entities.Rdv;

@RepositoryRestResource
public interface RdvRepository extends JpaRepository< Rdv,Long> {

}
