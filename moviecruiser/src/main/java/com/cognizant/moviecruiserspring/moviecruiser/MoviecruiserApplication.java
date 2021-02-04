package com.cognizant.moviecruiserspring.moviecruiser;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;
import com.cognizant.moviecruiser.util.DateUtil;




@SpringBootApplication
@EnableJpaRepositories("com")
@ComponentScan("com")
@EntityScan("com")
public class MoviecruiserApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(MoviecruiserApplication.class);

private static MovieService movieService;


	public static void main(String[] args) throws ParseException {
		ApplicationContext context =SpringApplication.run(MoviecruiserApplication.class, args);
		movieService=context.getBean(MovieService.class);
		getMovieListAdminTest();
		getMovieListCustomerTest();
		getMovieTest();
		modifyMovieTest();
	}
	

	private static void modifyMovieTest() throws ParseException {
		LOGGER.info("Start");

		Movie movie=new Movie(4,"Johnny English Reborn",(float) 6.3,true,DateUtil.convertToDate("07/05/2017"),"Comedy",true);
		movieService.modifyMovie(movie);
		Optional<Movie> movieSaved=movieService.getMovie(4);
		LOGGER.debug("Movie Info Modified:{}", movieSaved);

		
		LOGGER.info("End");
		
	}


	private static void getMovieTest() {
		// TODO Auto-generated method stub
LOGGER.info("Start");

	
		
		Optional<Movie> movie=movieService.getMovie(1);
		LOGGER.debug("Movie:{}", movie);

		
		LOGGER.info("End");
		
	}


	private static void getMovieListCustomerTest() {
		// TODO Auto-generated method stub
		LOGGER.info("Start");

		List<Movie> movieList = movieService.getMovieListCustomer();

		LOGGER.debug("Movies:{}", movieList);

		LOGGER.info("End");
		
	}


	private static void getMovieListAdminTest() {
		LOGGER.info("Start");

		List<Movie> movieList = movieService.getMovieListAdmin();

		LOGGER.debug("Movies:{}", movieList);

		LOGGER.info("End");
		
		
	}

}
