package com.tcs.dao;

import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.data.jpa.repository.JpaRepository;

@Named
@Singleton
public interface EmployeeManagementRepository extends JpaRepository<Employee, Long> {
	List<Employee> findByEmployeeId(Integer employeeId);

	int deleteByEmployeeId(Integer employeeId);
}
