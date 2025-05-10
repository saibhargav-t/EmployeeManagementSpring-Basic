package com.spring.projects.employees.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.projects.employees.entity.Employees;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class DAOImpl implements EmployeesDAO {

    private EntityManager entityManager;

    public DAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employees> findAll() {
        TypedQuery<Employees> query = entityManager.createQuery("from Employees", Employees.class);
        return query.getResultList();
    }

    @Override
    public Employees findById(int id) {
        return entityManager.find(Employees.class, id);
    }

    @Override
    public Employees save(Employees e) {
        return entityManager.merge(e);
    }

    @Override
    public String deleteById(int id) {
        Employees employees = entityManager.find(Employees.class, id);
        entityManager.remove(employees);
        return "Employee deleted successfully with Id " + employees.getId();
    }

}
