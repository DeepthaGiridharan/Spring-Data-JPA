package com.cognizant.moviecruiser.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="movies")
public class Movie {
	 
		
		   @Id

			@Column(name="movie_id")
		   @GeneratedValue(strategy = GenerationType.IDENTITY)
			private int id;
		   @Column(name="movie_title")
			private String name;
		   @Column(name="movie_box_office")
			private float rating;
		   @Column(name="movie_active")
			private boolean active;
		   @Column(name="movie_date_of_launch")
			private Date dateOfLaunch;
		   @Column(name="movie_genre")
			private String genre;
		   @Column(name="movie_teaser")
			private boolean teaser;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public float getRating() {
			return rating;
		}
		public void setRating(float rating) {
			this.rating = rating;
		}
		public boolean isActive() {
			return active;
		}
		public void setActive(boolean active) {
			this.active = active;
		}
		public Date getDateOfLaunch() {
			return dateOfLaunch;
		}
		public void setDateOfLaunch(Date dateOfLaunch) {
			this.dateOfLaunch = dateOfLaunch;
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public boolean isTeaser() {
			return teaser;
		}
		public void setTeaser(boolean teaser) {
			this.teaser = teaser;
		}
		@Override
		public String toString() {
			return "Movie [id=" + id + ", name=" + name + ", rating=" + rating + ", active=" + active
					+ ", dateOfLaunch=" + dateOfLaunch + ", genre=" + genre + ", teaser=" + teaser + "]";
		}
		public Movie(int id, String name, float rating, boolean active, Date dateOfLaunch, String genre,
				boolean teaser) {
			super();
			this.id = id;
			this.name = name;
			this.rating = rating;
			this.active = active;
			this.dateOfLaunch = dateOfLaunch;
			this.genre = genre;
			this.teaser = teaser;
		}
		public Movie() {
			super();
			// TODO Auto-generated constructor stub
		}

}
