package com.spring.projects.employees.dao;

import java.util.List;

import com.spring.projects.employees.entity.Employees;

public interface EmployeesDAO {

    List<Employees> findAll();

    Employees findById(int id);

    Employees save(Employees e);

    String deleteById(int id);

}
