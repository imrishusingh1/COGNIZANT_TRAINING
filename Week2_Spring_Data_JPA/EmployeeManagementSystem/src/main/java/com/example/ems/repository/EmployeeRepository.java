package com.example.ems.repository;

import com.example.ems.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name);
    List<Employee> findByDepartmentId(Long departmentId);
    List<Employee> findByPosition(String position);
    List<Employee> findBySalaryGreaterThan(Double salary);
    List<Employee> findByNameContainingIgnoreCase(String keyword);

    @Query("SELECT e FROM Employee e WHERE e.department.name = :deptName")
    List<Employee> findByDepartmentName(@Param("deptName") String deptName);

    @Query(value = "SELECT * FROM employees WHERE salary BETWEEN :min AND :max", nativeQuery = true)
    List<Employee> findBySalaryBetween(@Param("min") Double min, @Param("max") Double max);

    @Query(name = "Employee.findByDepartmentName")
    List<Employee> findByDeptName(@Param("deptName") String deptName);

    Page<Employee> findByPosition(String position, Pageable pageable);

    @Query("SELECT e.name as name, e.email as email FROM Employee e WHERE e.department.id = :deptId")
    List<EmployeeProjection> findProjectionByDepartmentId(@Param("deptId") Long deptId);

    interface EmployeeProjection {
        String getName();
        String getEmail();
    }
}
