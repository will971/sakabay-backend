package com.mowil.ats.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mowil.ats.entities.Role;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository< Role,Long> {

}
