package com.cognizant.ormlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repositor.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired

	private EmployeeRepository employeeRepository;

	@Transactional

	public void save(Employee employee) {

	employeeRepository.save(employee);

	}
	@Transactional

	public Employee get(int id) {

	return employeeRepository.findById(id).get();
}
	@Transactional

	public List<Employee> getAllPermanentEmployees() {

	return employeeRepository.getAllPermanentEmployees();
}
	public double getAverageSalary(int dpId) {

		return employeeRepository.getAverageSalary(dpId);
	}
	public List<Employee> getAllEmployeesNative() {
		
		return employeeRepository.getAllEmployeesNative();
	}
	
}

