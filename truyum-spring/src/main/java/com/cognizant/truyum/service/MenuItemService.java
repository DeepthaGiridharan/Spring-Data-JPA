package com.cognizant.truyum.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.truyumspring.MenuItemRepository;
@Service
public class MenuItemService {
	@Autowired
	private MenuItemRepository menuItemRepository;
    @Transactional
	public List<MenuItem> getMenuItemListAdmin() {
    	List<MenuItem> menuItemList=menuItemRepository.findAll();
    
		return menuItemList;
    	
	}
    @Transactional
	public List<MenuItem> getMenuItemListCustomer() {
    	List<MenuItem> menuItemList=menuItemRepository.findByDateOfLaunchAndActive();
    	return menuItemList;
		
	}
    @Transactional
	public void modifyMenuItem(MenuItem menuItem) {
    	menuItemRepository.save(menuItem);
	
	}
    @Transactional
	public Optional<MenuItem> getMenuItem(int menuItemId) {
    	Optional<MenuItem> menuItem=menuItemRepository.findById(menuItemId);
    	return menuItem;
    }
    
}

