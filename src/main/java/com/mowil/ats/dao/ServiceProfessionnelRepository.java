package com.mowil.ats.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mowil.ats.entities.ServiceProfessionnel;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ServiceProfessionnelRepository extends JpaRepository< ServiceProfessionnel,Long> {

}
