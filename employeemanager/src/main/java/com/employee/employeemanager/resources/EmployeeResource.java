// this is controller where we will receive http request from the client and send it to the application
package com.employee.employeemanager.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employeemanager.model.Employee;
import com.employee.employeemanager.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;
    public EmployeeResource(EmployeeService employeeService)
    {
        this.employeeService=employeeService;
    }
    //@CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee()
    {
        List<Employee> employees = employeeService.findAllEmployee();
        return new ResponseEntity<>(employees , HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id)
    {
       return employeeService.findEmployeeById(id);
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> setEmployee(@RequestBody Employee employee)
    {
       Employee newEmployee = employeeService.addEmployee(employee);
       return new ResponseEntity<>(newEmployee , HttpStatus.CREATED);
    }
    @PostMapping("/addMany")
    public ResponseEntity<List<Employee>> setEmployeeMany(@RequestBody List<Employee> employeeList)
    {
        List<Employee> newEmployeeeList = new ArrayList<Employee>();
        for(Employee e: employeeList)
        {
            Employee newEmployee = employeeService.addEmployee(e);
            newEmployeeeList.add(newEmployee);
        }
        return new ResponseEntity<>(newEmployeeeList,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
    {
       Employee updateEmployees = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployees , HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id)
    {
       employeeService.deleteEmployee(id);
       return new ResponseEntity<>(HttpStatus.OK);
       
    }

}
