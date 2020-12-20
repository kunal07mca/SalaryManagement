package com.nhpc.demo.repository;

import com.nhpc.demo.model.emp.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author  Kunal Gupta
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
