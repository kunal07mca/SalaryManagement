package com.nhpc.demo.service.impl;

import com.nhpc.demo.repository.EmployeeRepository;
import com.nhpc.demo.model.emp.Employee;
import com.nhpc.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author  Kunal Gupta
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return repository.findById(id).orElse(new Employee());
    }

    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public void delete(int id) {
        repository.findById(id).ifPresent(Employee -> repository.delete(Employee));
    }
}
