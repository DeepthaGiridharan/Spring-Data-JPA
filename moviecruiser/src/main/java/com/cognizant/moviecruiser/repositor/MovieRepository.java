package com.cognizant.moviecruiser.repositor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.moviecruiser.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	@Query(value="Select * from movies where movie_date_of_launch<=curdate() and movie_active=true",nativeQuery=true)
	public List<Movie> findByDateOfLaunchAndActive(); 

}
