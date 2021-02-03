package com.cognizant.ormlearn;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.model.AttemptOption;
import com.cognizant.ormlearn.model.AttemptQuestion;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repositor.StockRepository;
import com.cognizant.ormlearn.service.AttemptService;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;


@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;
	private static AttemptService attemptService;
	
	@Autowired
	static StockRepository stockRepository;
	
	private static void testGetAllCountries() {

		LOGGER.info("Start");

		List<Country> countries = countryService.getAllCountries();

		LOGGER.debug("countries={}", countries);

		LOGGER.info("End");

		}
	private static void getAllCountriesTest() throws CountryNotFoundException {

		LOGGER.info("Start");

		Country country = countryService.findCountryByCode("IN");

		LOGGER.debug("Country:{}", country);

		LOGGER.info("End");

		}
	private static void testAddCountry() throws CountryNotFoundException {
		LOGGER.info("Start");
		Country country=new Country();
		country.setCode("XC");
		country.setName("Xcountry");
		countryService.addCountry(country);
		Country country1 = countryService.findCountryByCode("XC");

		LOGGER.debug("Country:{}", country1);

		LOGGER.info("End");
		
		
	}
	private static void testUpdateCountry() throws CountryNotFoundException {
		LOGGER.info("Start");
		countryService.updateCountry("XC","Xcountries");
		Country country1 = countryService.findCountryByCode("XC");

		LOGGER.debug("Country:{}", country1);

		LOGGER.info("End");
	}
	private static void testDeleteCountry() throws CountryNotFoundException {
		LOGGER.info("Start");
		countryService.deleteCountry("XC");
		

		

		LOGGER.info("End");
	}
	private static void getCountriesByPartialName() throws CountryNotFoundException {

		LOGGER.info("Start");
		List<Country> country=new ArrayList<Country>();

		country = countryService.findCountryByPartialName("Y");

		LOGGER.debug("Country:{}", country);

		LOGGER.info("End");

		}
	private static void getCountriesByPartialNameStartingLetter() throws CountryNotFoundException {

		LOGGER.info("Start");
		List<Country> country=new ArrayList<Country>();

		country = countryService.findCountryByPartialNameStartingLetter("Y");

		LOGGER.debug("Country:{}", country);

		LOGGER.info("End");

		}
	private static void getFbSept2019(){

		LOGGER.info("Start");

		List<Stock> stockList = stockRepository.findByCodeAndDateLike("FB", "2019-9%");

		LOGGER.debug("stockList={}", stockList);

		LOGGER.info("End");


			}
	private static void getGoogleGreaterStock(){

		LOGGER.info("Start");

		List<Stock> stockList = stockRepository.findByCodeAndOpenGreaterThanAndCloseGreaterThan("GOOGL",
				BigDecimal.valueOf(1250), BigDecimal.valueOf(1250));

		LOGGER.debug("stockList={}", stockList);

		LOGGER.info("End");

		}
	private static void getTop3GreatestVolume(){

		LOGGER.info("Start");

		List<Stock> stockList = stockRepository.findTop3ByOrderByVolumeDesc();

		LOGGER.debug("stockList={}", stockList);

		LOGGER.info("End");

		}
	private static void getLowest3NetflixStock(){

		LOGGER.info("Start");

		List<Stock> stockList = stockRepository.findTop3ByCodeOrderByClose("NFLX");

		LOGGER.debug("stockList={}", stockList);

		LOGGER.info("End");

		}
	private static void testGetEmployee() {

		LOGGER.info("Start");

		Employee employee = employeeService.get(1);

		LOGGER.debug("Employee:{}", employee);

		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());

		LOGGER.info("End");

		}
	private static void testAddEmployee() throws java.text.ParseException{

		LOGGER.info("Start");
		Employee employee = new Employee();
		employee.setName("Lakshmi");
		employee.setSalary(100000);
		employee.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1998-09-23"));
		employee.setDepartment(departmentService.get(1));
		employee.setPermanent(false);
		employeeService.save(employee);
		Employee savedEmployee = employeeService.get(5);
		LOGGER.debug("Saved Employee:{}", savedEmployee);
		

		LOGGER.info("End");

	}
	private static void testUpdateEmployee() {

		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		Department department = departmentService.get(3);
		employee.setDepartment(department);
		employeeService.save(employee);
		Employee savedEmployee = employeeService.get(1);
		LOGGER.debug("Saved Employee:{}", savedEmployee);

		LOGGER.info("End");

	}

	private static void testGetDepartment() {
		LOGGER.info("Start");
		Department department=departmentService.get(2);
		Set<Employee> employeeList=department.getEmployeeList();
		LOGGER.debug("Employee List:{}", employeeList);
		LOGGER.info("End");
		
	}
	private static void testAddSkillToEmployee() {
		LOGGER.info("Start");
		Employee employee=employeeService.get(5);
		Skill skill=skillService.get(1);
		Set<Skill> employeeSkills = employee.getSkillList();
		employeeSkills.add(skill);
		employeeService.save(employee);
		Employee employeeSaved=employeeService.get(5);
		LOGGER.debug("Employee Skills:{}", employeeSaved);
		LOGGER.info("End");
	}
	
		public static void testGetAllPermanentEmployees() {

			LOGGER.info("Start");

			List<Employee> employees = employeeService.getAllPermanentEmployees();

			LOGGER.debug("Permanent Employees:{}", employees);

			employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));

			LOGGER.info("End");

			}
		public static void testGetAverageSalary() {

			LOGGER.info("Start");

			LOGGER.debug("Average Salary:{}", employeeService.getAverageSalary(2));
			
			LOGGER.info("End");
			

			

			}
		public static void testGetAllEmployeesNative() {

			LOGGER.info("Start");

			List<Employee> employees = employeeService.getAllEmployeesNative();

			LOGGER.debug("Employees:{}", employees);

			LOGGER.info("End");

		}

		public static void testGetAttemptDetail() {

			LOGGER.info("Start");

			Attempt attempt = attemptService.getAttempt(1, 1);

			LOGGER.debug("Attempt:{}", attempt);

			for (AttemptQuestion attemptQuestion : attempt.getAttemptQuestionList()) {
				System.out.println(attemptQuestion.getQuestions().getText());
				int no = 1;
				for (AttemptOption attemptOption : attemptQuestion.getAttemptOptionList()) {
					System.out.println(no + ") " + attemptOption.getOptions().getText() + " "
							+ attemptOption.getOptions().getScore() + " " + attemptOption.isSelected());
					no++;
				}

			}

			LOGGER.info("End");

		}
	public static void main(String[] args) throws CountryNotFoundException, ParseException {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        
		countryService = context.getBean(CountryService.class);
		employeeService=context.getBean(EmployeeService.class);
		stockRepository = context.getBean(StockRepository.class);
		departmentService=context.getBean(DepartmentService.class);
		skillService=context.getBean(SkillService.class);
		attemptService = context.getBean(AttemptService.class);
		
		LOGGER.info("Inside main");
		//Country
		/*testGetAllCountries();
		getAllCountriesTest();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();
        getCountriesByPartialName();
        getCountriesByPartialNameStartingLetter();
        
        //Stock
        getFbSept2019();
        getGoogleGreaterStock();
        getTop3GreatestVolume();
        getLowest3NetflixStock();
        
        //Employee
       testGetEmployee();
        testAddEmployee();
        testUpdateEmployee();
		testGetDepartment();
	     testAddSkillToEmployee();
		testGetAllPermanentEmployees();
		testGetAverageSalary();
		testGetAllEmployeesNative();*/
		
		
		testGetAttemptDetail();
      
        
		
		
	}

}
