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
    public EmployeeEntity updateEmployee(Long id, Employee employee) {
        EmployeeEntity existingEmployee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());

        return repository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Employee not found");
        }
        repository.deleteById(id);
    }
}

