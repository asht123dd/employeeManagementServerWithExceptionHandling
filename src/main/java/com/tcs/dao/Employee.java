package com.tcs.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer employeeId;
	private String employeeName;
	private String currentAddress;
	private String previousAddress1;
	private Integer yearsOfExperience;
	private String previousAddress2;
	private String previousAddress3;
	private String graduatedFrom;
	private String graduateDegree;
	private Integer graduationYear;
	private Integer intermediateYear;
	private Integer matriculationYear;

	public Integer getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(Integer yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getPreviousAddress1() {
		return previousAddress1;
	}

	public void setPreviousAddress1(String previousAddress1) {
		this.previousAddress1 = previousAddress1;
	}

	public String getPreviousAddress2() {
		return previousAddress2;
	}

	public void setPreviousAddress2(String previousAddress2) {
		this.previousAddress2 = previousAddress2;
	}

	public String getPreviousAddress3() {
		return previousAddress3;
	}

	public void setPreviousAddress3(String previousAddress3) {
		this.previousAddress3 = previousAddress3;
	}

	public String getGraduatedFrom() {
		return graduatedFrom;
	}

	public void setGraduatedFrom(String graduatedFrom) {
		this.graduatedFrom = graduatedFrom;
	}

	public String getGraduateDegree() {
		return graduateDegree;
	}

	public void setGraduateDegree(String graduateDegree) {
		this.graduateDegree = graduateDegree;
	}

	public Integer getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(Integer graduationYear) {
		this.graduationYear = graduationYear;
	}

	public Integer getIntermediateYear() {
		return intermediateYear;
	}

	public void setIntermediateYear(Integer intermediateYear) {
		this.intermediateYear = intermediateYear;
	}

	public Integer getMatriculationYear() {
		return matriculationYear;
	}

	public void setMatriculationYear(Integer matriculationYear) {
		this.matriculationYear = matriculationYear;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

}
