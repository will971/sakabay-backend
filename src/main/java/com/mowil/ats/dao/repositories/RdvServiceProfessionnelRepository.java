package com.mowil.ats.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mowil.ats.dao.entities.RdvServiceProfessionnel;

@RepositoryRestResource
public interface RdvServiceProfessionnelRepository extends JpaRepository< RdvServiceProfessionnel,Long> {

}
