package com.spring.projects.employees.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.projects.employees.entity.Employees;
import com.spring.projects.employees.jparepository.EmployeesRepository;

@Service
public class ServiceImplUsingJpaRepo implements EmployeeService {

    private EmployeesRepository employeesRepository;

    public ServiceImplUsingJpaRepo(/* EmployeesDAO theEd, */ EmployeesRepository tER) {
        employeesRepository = tER;
    }

    @Override
    public List<Employees> findAll() {
        return employeesRepository.findAll();
    }

    @Override
    public Employees findById(int id) {
        Optional<Employees> result = employeesRepository.findById(id);
        Employees employees = null;
        if (result.isPresent()) {
            employees = result.get();
        }
        return employees;
    }

    @Override
    public Employees save(Employees e) {
        return employeesRepository.save(e);
    }

    @Override
    public String deleteById(int id) {

        return employeesRepository.findById(id).map(employee -> {
            employeesRepository.delete(employee);
            return "Delete employee id - " + id;
        }).orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

}
