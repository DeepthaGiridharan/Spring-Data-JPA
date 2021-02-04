package com.cognizant.moviecruiser.repositor;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.moviecruiser.model.Favorite;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite,Map<Integer,Integer>> {

}


