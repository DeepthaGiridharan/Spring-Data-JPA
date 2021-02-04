package com.cognizant.truyum.truyumspring;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.MenuItem;
@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
	@Query(value="Select * from menu_item where me_date_of_launch<=curdate() and me_active=true",nativeQuery=true)
	public List<MenuItem> findByDateOfLaunchAndActive();

}
