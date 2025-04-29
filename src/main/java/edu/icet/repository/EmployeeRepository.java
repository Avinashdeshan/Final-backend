package edu.icet.repository;

import edu.icet.dto.Employee;
import edu.icet.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
    Optional<Employee> findByEmail(String email);
}
