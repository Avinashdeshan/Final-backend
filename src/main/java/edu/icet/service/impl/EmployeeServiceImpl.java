package edu.icet.service.impl;

import edu.icet.dto.Employee;
import edu.icet.entity.EmployeeEntity;
import edu.icet.repository.EmployeeRepository;
import edu.icet.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeRepository repository;

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        Optional<Employee> existingEmployee = repository.findByEmail(employee.getEmail());
        if (existingEmployee.isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        return null;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {

    }
}

