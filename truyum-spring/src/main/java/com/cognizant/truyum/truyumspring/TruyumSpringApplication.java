package com.cognizant.truyum.truyumspring;

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

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;
import com.cognizant.truyum.util.DateUtil;



@SpringBootApplication
@EnableJpaRepositories("com")
@ComponentScan("com")
@EntityScan("com")
public class TruyumSpringApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumSpringApplication.class);
	private static MenuItemService menuItemService;
	public static void main(String[] args) throws ParseException {
		ApplicationContext context =SpringApplication.run(TruyumSpringApplication.class, args);
		menuItemService=context.getBean(MenuItemService.class);
		getMenuItemListAdminTest();
		getMenuItemListCustomerTest();
		getMenuItemTest();
		modifyMenuItemTest();
	}
	private static void modifyMenuItemTest() throws ParseException {
		LOGGER.info("Start");

		MenuItem menuItem=new MenuItem(4,"Potato Wedges",(float)60,true,DateUtil.convertToDate("07/05/2017"),"Starters",false);
		menuItemService.modifyMenuItem(menuItem);
		Optional<MenuItem> menuItemSaved=menuItemService.getMenuItem(4);
		LOGGER.debug("Menu Item Modified:{}", menuItemSaved);

		
		LOGGER.info("End");
	}
	private static void getMenuItemTest() {
		LOGGER.info("Start");

	
		
		Optional<MenuItem> menuItem=menuItemService.getMenuItem(2);
		LOGGER.debug("Menu Item:{}", menuItem);

		
		LOGGER.info("End");
		
		
	}
	private static void getMenuItemListCustomerTest() {
		LOGGER.info("Start");

		List<MenuItem> menuItemList = menuItemService.getMenuItemListCustomer();

		LOGGER.debug("Menu Items:{}", menuItemList);

		LOGGER.info("End");
		
	}
	private static void getMenuItemListAdminTest() {
		LOGGER.info("Start");

		List<MenuItem> menuItemList = menuItemService.getMenuItemListAdmin();

		LOGGER.debug("Menu Items:{}", menuItemList);

		LOGGER.info("End");
		
	}

}
