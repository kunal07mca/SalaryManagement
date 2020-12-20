package com.nhpc.demo.service;

import com.nhpc.demo.model.emp.Employee;

import java.util.List;

/**
 * @author  Kunal Gupta
 */

public interface EmployeeService {

    List<?> findAll();

    Employee findById(int id);

    Employee save(Employee superHero);

    Employee update(Employee superHero);

    void delete(int id);
}
