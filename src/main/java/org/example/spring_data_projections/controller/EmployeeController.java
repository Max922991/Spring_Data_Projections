package org.example.spring_data_projections.controller;

import lombok.RequiredArgsConstructor;
import org.example.spring_data_projections.model.Department;
import org.example.spring_data_projections.model.Employee;
import org.example.spring_data_projections.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import projection.EmployeeProjection;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/employees/{id}/projection")
    public EmployeeProjection getEmployeeProjection(@PathVariable Long id) {
        return employeeService.getEmployeeProjectionById(id);
    }

    @PostMapping("/departments")
    public Department createDepartment(@RequestBody Department department) {
        return employeeService.saveDepartment(department);
    }

    @GetMapping("/departments/{id}")
    public Optional<Department> getDepartment(@PathVariable Long id) {
        return employeeService.getDepartmentById(id);
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return employeeService.getAllDepartments();
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        employeeService.deleteDepartment(id);
    }
}
