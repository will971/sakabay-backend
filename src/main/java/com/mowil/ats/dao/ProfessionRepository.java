package com.mowil.ats.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mowil.ats.entities.Profession;

public interface ProfessionRepository extends JpaRepository< Profession ,Long>  {

}