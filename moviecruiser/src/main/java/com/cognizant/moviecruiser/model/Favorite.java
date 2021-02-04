package com.cognizant.moviecruiser.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "favorites")
@IdClass(FavoriteId.class)
public class Favorite 
 {     @Id
		@Column(name = "user_id")
		private int userId;
		@Id
		@Column(name = "movie_id")
		private int movieId;
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public int getMovieId() {
			return movieId;
		}
		public void setMovieId(int movieId) {
			this.movieId = movieId;
		}
		public Favorite(int userId, int movieId) {
			super();
			this.userId = userId;
			this.movieId = movieId;
		}

}
