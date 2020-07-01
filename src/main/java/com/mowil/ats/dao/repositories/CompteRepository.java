package com.mowil.ats.dao.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mowil.ats.dao.entities.Compte;
@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {
	@Query("select c from Compte c where c.mail =?1 or c.username=?1")
	public Optional<Compte> findOneByMailOrUsername(String nameOrUsername);

}
