package com.spring.projects.employees.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.projects.employees.entity.Employees;

@RepositoryRestResource(path = "employees")
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

}
