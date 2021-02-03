package com.cognizant.ormlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.repositor.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Transactional

	public Department get(int id) {

	

	return departmentRepository.findById(id).get();

	}
	@Transactional

	public void save(Department department) {

	

	departmentRepository.save(department);

	
	}

}
