package com.ra.model.dao;

import com.ra.model.entity.Employee;
import com.ra.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao implements IEmployeeDao
{

    @Override
    public List<Employee> findAll()
    {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = ConnectDB.getConnection();
        try
        {
            PreparedStatement prepare = connection.prepareStatement("select * from employee");
            ResultSet rs = prepare.executeQuery();
            while (rs.next())
            {
                Employee employee = Employee.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .address(rs.getString("address"))
                        .phone(rs.getString("phone"))
                        .status(rs.getBoolean("status"))
                        .build();
                employeeList.add(employee);
            }
            return employeeList;
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            ConnectDB.closeConnection(connection);
        }
    }

    @Override
    public Employee findById(Integer id)
    {
        Connection connection = ConnectDB.getConnection();
        try
        {
            PreparedStatement prepare = connection.prepareStatement("select * from employee" +
                    "where employee.id = ?");
            prepare.setInt(1, id);
            ResultSet rs = prepare.executeQuery();
            if (rs.next())
            {
                Employee employee = Employee.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .address(rs.getString("address"))
                        .phone(rs.getString("phone"))
                        .status(rs.getBoolean("status"))
                        .build();
                return employee;
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            ConnectDB.closeConnection(connection);
        }
        return null;
    }

    @Override
    public void save(Employee employee)
    {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement prepare = null;
        try
        {
            if (employee.getId() == null)
            {
                prepare = connection.prepareStatement("insert into " +
                        "employee (name, address, phone, status) values " +
                        "(?,?,?,?)");

            } else
            {
                prepare = connection.prepareStatement("update employee " +
                        "set name = ?, address = ?, phone = ?, status = ? where id = ?");
                prepare.setInt(5, employee.getId());
            }
            prepare.setString(1, employee.getName());
            prepare.setString(2, employee.getAddress());
            prepare.setString(3, employee.getPhone());
            prepare.setBoolean(4, employee.getStatus());
            prepare.executeUpdate();
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            ConnectDB.closeConnection(connection);
        }
    }

    @Override
    public void deleteById(Integer id)
    {
        Connection connection = ConnectDB.getConnection();
        try
        {
            PreparedStatement prepare = connection.prepareStatement("delete from employee" +
                    "where id = ?");
            prepare.setInt(1, id);
            prepare.executeUpdate();
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            ConnectDB.closeConnection(connection);
        }
    }
}
