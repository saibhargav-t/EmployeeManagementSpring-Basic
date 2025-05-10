package com.spring.projects.employees.service;

import java.util.List;

import com.spring.projects.employees.entity.Employees;

public interface EmployeeService {

    List<Employees> findAll();

    Employees findById(int id);

    Employees save(Employees e);

    String deleteById(int id);
}
