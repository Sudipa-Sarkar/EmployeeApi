package com.employee.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.employee.employeemanager.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long Id);
}
