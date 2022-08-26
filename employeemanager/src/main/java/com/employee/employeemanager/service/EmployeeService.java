//the different type of functionality that the website will provide
package com.employee.employeemanager.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employeemanager.exceptions.UserNotFoundException;
import com.employee.employeemanager.model.Employee;
import com.employee.employeemanager.repo.EmployeeRepo;
import java.util.List;


@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo)
    {
       this.employeeRepo=employeeRepo;
    }
   public Employee addEmployee(Employee emplopyee)
   {
    emplopyee.setEmployeeCode(UUID.randomUUID().toString());
    return employeeRepo.save(emplopyee);
   }
   
public List<Employee> findAllEmployee()
   {
    return employeeRepo.findAll();
   }
public Employee updateEmployee(Employee employee)
{
    return employeeRepo.save(employee);
}
public Employee findEmployeeById(Long id)
{
    return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User id: " + id + "was not found"));
}
public void deleteEmployee(Long id)
{
   employeeRepo.deleteEmployeeById(id);
}
}
