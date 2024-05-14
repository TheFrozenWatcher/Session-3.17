package com.ra.controller;

import com.ra.model.entity.Employee;
import com.ra.model.service.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController
{
    private final IEmployee employeeService;

    @Autowired
    public EmployeeController(IEmployee employeeService)
    {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public String employeeList(Model model)
    {
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employees", employeeList);
        return "employee";
    }

    @GetMapping("/add")
    public String addView()
    {
        return "addemployee";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Integer id)
    {
        employeeService.deleteById(id);
        return "employee";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model)
    {
        Employee employee = employeeService.findById(id);
        model.addAttribute("update", employee);
        return "updateemployee";
    }

    @PostMapping("/addemployee")
    public String addEmployee(@ModelAttribute Employee employee)
    {
        employeeService.save(employee);
        return "redirect:/employee";
    }

    @PostMapping("/updateemployee")
    public String updateEmployee(@ModelAttribute Employee employee)
    {
        employeeService.save(employee);
        return "redirect:/employee";
    }
}
