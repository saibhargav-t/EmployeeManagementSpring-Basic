package com.spring.projects.employees.service;

import java.util.List;

import com.spring.projects.employees.dao.EmployeesDAO;
import com.spring.projects.employees.entity.Employees;

public class ServiceImplUsingEM implements EmployeeService {
    private EmployeesDAO employeesDao;

    public ServiceImplUsingEM(EmployeesDAO theEmployeesDao) {
        employeesDao = theEmployeesDao;
    }

    @Override
    public List<Employees> findAll() {
        return employeesDao.findAll();
    }

    @Override
    public Employees findById(int id) {
        return employeesDao.findById(id);
    }

    @Override
    public Employees save(Employees e) {
        return employeesDao.save(e);
    }

    @Override
    public String deleteById(int id) {
        return employeesDao.deleteById(id);
    }

}
