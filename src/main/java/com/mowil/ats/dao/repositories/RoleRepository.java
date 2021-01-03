package com.mowil.ats.dao.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mowil.ats.dao.entities.Role;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long> {

	@Query("select r from Role r where r.libelle =?1")
	public Optional<Role> findOneByLibelle(String nameOrUsername);
}
