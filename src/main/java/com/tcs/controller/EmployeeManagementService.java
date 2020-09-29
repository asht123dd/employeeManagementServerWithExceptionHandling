package com.tcs.controller;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.tcs.dao.Employee;
import com.tcs.dao.EmployeeManagementRepository;

@Named
@Singleton
public class EmployeeManagementService {
	private EmployeeManagementRepository employeeManagementRepository;

	@Inject
	public EmployeeManagementService(EmployeeManagementRepository employeeManagementRepository) {
		this.employeeManagementRepository = employeeManagementRepository;
	}

	public void saveEmployeeData(Integer employeeId, Employee employee) {
		employee.setEmployeeId(employeeId);
		employeeManagementRepository.save(employee);
	}

}
