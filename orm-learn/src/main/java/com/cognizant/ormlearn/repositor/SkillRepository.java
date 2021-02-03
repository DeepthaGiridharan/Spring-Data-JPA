package com.cognizant.ormlearn.repositor;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.cognizant.ormlearn.model.Skill;


public interface SkillRepository extends JpaRepository<Skill, Integer>  {

}
