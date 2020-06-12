package com.mowil.ats.dao;

import com.mowil.ats.entities.Professionnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProfessionnelRepository extends JpaRepository<Professionnel,Long> {

}
