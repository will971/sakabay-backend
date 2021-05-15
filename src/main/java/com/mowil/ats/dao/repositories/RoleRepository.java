package com.mowil.ats.dao.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mowil.ats.dao.entities.Role;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Operation(summary = "Recherche d'un rôle selon son libellé", security = @SecurityRequirement(name = "bearerAuth"))
    // @Query("select r from Role r where r.libelle =?1")
    public Optional<Role> findOneByLibelle(String nameOrUsername);

}
