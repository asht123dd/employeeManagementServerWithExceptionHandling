package com.tcs.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcs.dao.Employee;
import com.tcs.dao.EmployeeManagementRepository;
import com.tcs.exception.EmployeeManagementException;

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

	public ResponseEntity<String> getEmployeeData(Integer employeeId) {
		List<Employee> employeeDetails = employeeManagementRepository.findByEmployeeId(employeeId);
		Employee employee;
		String jsonStr = "No employee found";
		if (employeeDetails != null && !employeeDetails.isEmpty()) {
			employee = employeeDetails.get(0);
			ObjectMapper Obj = new ObjectMapper();
			try {
				jsonStr = Obj.writeValueAsString(employee);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				jsonStr = "Error in parsing";
				e.printStackTrace();
				throw new EmployeeManagementException(jsonStr);
			}

		} else {
			return new ResponseEntity<>(jsonStr, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(jsonStr, HttpStatus.OK);
	}

}
