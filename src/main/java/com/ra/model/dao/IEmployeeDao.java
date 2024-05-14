package com.ra.model.dao;

import com.ra.model.entity.Employee;

import java.util.List;

public interface IEmployeeDao
{
    List<Employee> findAll();

    Employee findById(Integer id);

    void save(Employee employee);

    void deleteById(Integer id);
}
