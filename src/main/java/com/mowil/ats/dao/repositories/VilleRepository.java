package com.mowil.ats.dao.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mowil.ats.dao.entities.Ville;

@RepositoryRestResource
public interface VilleRepository extends JpaRepository<Ville, Long> {

    @Query("select v from Ville v where v.libelle=?1")
    public Optional<Ville> findOneByLibelle(String libelle);
}
