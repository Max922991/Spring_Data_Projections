package org.example.spring_data_projections.repository;


import org.example.spring_data_projections.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import projection.EmployeeProjection;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e.firstName AS firstName, e.lastName AS lastName, e.position AS position, " +
            "d.name AS departmentName FROM Employee e JOIN e.department d WHERE e.id = :id")
    EmployeeProjection findEmployeeProjectionById(@Param("id") Long id);
}