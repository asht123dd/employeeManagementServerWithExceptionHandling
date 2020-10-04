package com.tcs.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcs.dao.Employee;
import com.tcs.dao.EmployeeManagementRepository;
import com.tcs.exception.EmployeeManagementException;
import com.tcs.service.EmployeeManagementService;

@Controller
@RequestMapping("/")
public class EmployeeManagementController {
	private EmployeeManagementRepository employeeManagementRepository;
	private EmployeeManagementService employeeManagementService;

	@Autowired
	public EmployeeManagementController(EmployeeManagementService employeeManagementService,
			EmployeeManagementRepository employeeManagementRepository) {
		this.employeeManagementRepository = employeeManagementRepository;
		this.employeeManagementService = employeeManagementService;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public ResponseEntity<String> employeeDetails(@PathVariable("employeeId") Integer employeeId, Model model) {
		ResponseEntity<String> response = null;
		try {
			response = employeeManagementService.getEmployeeData(employeeId);
		} catch (EmployeeManagementException employeeManagementException) {
			new ResponseEntity<>(employeeManagementException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception exception) {
			new ResponseEntity<>("Unknown error occured", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/{employeeId}", method = RequestMethod.POST)
	public String addToEmployeeManagement(@PathVariable("employeeId") Integer employeeId,
			@RequestBody Employee employee) {
		employeeManagementService.saveEmployeeData(employeeId, employee);
		return "redirect:/{employeeId}";
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/{employeeId}", method = RequestMethod.PUT)
	public String updateToEmployeeManagement(@PathVariable("employeeId") Integer employeeId,
			@RequestBody Employee employee) {
		System.out.println("inside PUT");
		List<Employee> employeeDetails = employeeManagementRepository.findByEmployeeId(employeeId);
		Employee retrievedEmployee = employeeDetails.get(0);
		System.out.println("---for Angular employee----");
		System.out.println("current address=" + employee.getCurrentAddress());
		System.out.println("ID=" + employee.getId());
		System.out.println("employeeID" + employee.getEmployeeId());
		System.out.println("---for retrieved employee----");
		System.out.println("current address=" + retrievedEmployee.getCurrentAddress());
		System.out.println("ID=" + retrievedEmployee.getId());
		System.out.println("employeeID" + retrievedEmployee.getEmployeeId());

		Long id = retrievedEmployee.getId();
		employee.setId(id);
		employeeManagementRepository.save(employee);
		return "redirect:/{employeeId}";
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@Transactional
	@RequestMapping(value = "/{employeeId}", method = RequestMethod.DELETE)
	public String deleteFromEmployeeManagement(@PathVariable("employeeId") Integer employeeId) {
		employeeManagementRepository.deleteByEmployeeId(employeeId);
		return "redirect:/{employeeId}";
	}
}
