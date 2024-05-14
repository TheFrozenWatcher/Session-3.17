package com.ra.model.service.impl;

import com.ra.model.dao.EmployeeDao;
import com.ra.model.dao.IEmployeeDao;
import com.ra.model.entity.Employee;
import com.ra.model.service.IEmployee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployee
{
    private static final IEmployeeDao employeeDao = new EmployeeDao();

    @Override
    public List<Employee> findAll()
    {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(Integer id)
    {
        return employeeDao.findById(id);
    }

    @Override
    public void save(Employee employee)
    {
        employeeDao.save(employee);
    }

    @Override
    public void deleteById(Integer id)
    {
        employeeDao.deleteById(id);
    }
}
