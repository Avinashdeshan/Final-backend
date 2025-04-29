package edu.icet.service.impl;

import edu.icet.dto.Employee;
import edu.icet.entity.EmployeeEntity;
import edu.icet.repository.EmployeeRepository;
import edu.icet.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeRepository repository;
    final ModelMapper mapper;

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public EmployeeEntity createEmployee(Employee employee) {
        if (employee == null || employee.getEmail() == null) {
            throw new RuntimeException("Employee or Email is null");
        }

        Optional<EmployeeEntity> existingEmployee = repository.findByEmail(employee.getEmail());
        if (existingEmployee.isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        EmployeeEntity entity = mapper.map(employee, EmployeeEntity.class);
        return repository.save(entity);
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

