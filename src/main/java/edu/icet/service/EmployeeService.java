package edu.icet.service;

import edu.icet.dto.Employee;
import edu.icet.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    List<EmployeeEntity> getAllEmployees();

    Employee createEmployee(Employee employee);

    EmployeeEntity updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);
}
