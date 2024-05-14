package com.ra.model.service;

import com.ra.model.entity.Employee;

import java.util.List;

public interface IEmployee
{
    List<Employee> findAll();

    Employee findById(Integer id);

    void save(Employee employee);

    void deleteById(Integer id);
}
