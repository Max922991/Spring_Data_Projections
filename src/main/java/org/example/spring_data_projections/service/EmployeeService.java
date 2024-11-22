package org.example.spring_data_projections.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.spring_data_projections.model.Department;
import org.example.spring_data_projections.model.Employee;
import org.example.spring_data_projections.repository.DepartmentRepository;
import org.example.spring_data_projections.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import projection.EmployeeProjection;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Employee with id " + id + " not found"));
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeProjection getEmployeeProjectionById(Long id) {
        return employeeRepository.findEmployeeProjectionById(id);
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}