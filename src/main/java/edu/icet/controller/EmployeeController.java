package edu.icet.controller;

import edu.icet.dto.Employee;
import edu.icet.entity.EmployeeEntity;
import edu.icet.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeController {

    final EmployeeService service;

    @GetMapping("/get-all")
    public List<EmployeeEntity> getAll(){
        return service.getAllEmployees();
    }

    @PostMapping("/add")
    public Employee create(Employee employee){
        return service.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public EmployeeEntity update(@PathVariable Long id, @Valid @RequestBody Employee employee){
        return service.updateEmployee(id,employee );
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        service.deleteEmployee(id);
    }
}
