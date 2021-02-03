package com.cognizant.ormlearn.repositor;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

	public List<Country> findByNameContainingOrderByNameAsc(String partialName);

	public List<Country> findByNameStartingWithOrderByNameAsc(String partialName);

}
