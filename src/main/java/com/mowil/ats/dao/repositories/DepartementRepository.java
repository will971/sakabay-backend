package com.mowil.ats.dao.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mowil.ats.dao.entities.Departement;

@RepositoryRestResource
public interface DepartementRepository extends JpaRepository<Departement, Long> {
    @Query("select d from Departement d where d.libelle=?1")
    Optional<Departement> findOneByLibelle(String libelle);

}
