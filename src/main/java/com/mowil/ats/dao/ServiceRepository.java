package com.mowil.ats.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mowil.ats.entities.Service;

public interface ServiceRepository extends JpaRepository< Service,Long>  {

}
