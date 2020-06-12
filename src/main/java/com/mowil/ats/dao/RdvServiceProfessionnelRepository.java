package com.mowil.ats.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mowil.ats.entities.RdvServiceProfessionnel;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RdvServiceProfessionnelRepository extends JpaRepository< RdvServiceProfessionnel,Long> {

}
