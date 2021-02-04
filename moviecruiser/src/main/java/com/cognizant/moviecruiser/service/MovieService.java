package com.cognizant.moviecruiser.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.repositor.MovieRepository;

@Service
public class MovieService {
	
	
		@Autowired
		private MovieRepository movieRepository;
	    @Transactional
		public List<Movie> getMovieListAdmin() {
	    	List<Movie> movieList=movieRepository.findAll();
	    
			return movieList;
	    	
		}
	    @Transactional
		public List<Movie> getMovieListCustomer() {
	    	List<Movie> movieList=movieRepository.findByDateOfLaunchAndActive();
	    	return movieList;
			
		}
	    @Transactional
		public void modifyMovie(Movie movie) {
	    	movieRepository.save(movie);
		
		}
	    @Transactional
		public Optional<Movie> getMovie(int movieId) {
	    	Optional<Movie> movie=movieRepository.findById(movieId);
	    	return movie;
	    }
	    
	}


