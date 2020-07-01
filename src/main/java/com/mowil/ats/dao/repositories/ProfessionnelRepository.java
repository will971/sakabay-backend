package com.mowil.ats.dao;

import com.mowil.ats.entities.Professionnel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProfessionnelRepository extends JpaRepository<Professionnel,Long> {

	@Query(" select p from Professionnel p " +
            " where p.mail=?1")
	public Optional<Professionnel> findProfessionnelByUsername(String username);
}