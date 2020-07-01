package com.mowil.ats.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mowil.ats.dao.entities.ServiceProfessionnel;

@RepositoryRestResource
public interface ServiceProfessionnelRepository extends JpaRepository< ServiceProfessionnel,Long> {

}