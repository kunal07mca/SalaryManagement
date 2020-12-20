package com.nhpc.demo.service.impl;

import com.nhpc.demo.model.emp.Employee;
import com.nhpc.demo.repository.EmployeeRepository;
import com.nhpc.demo.service.FileService;
import com.nhpc.demo.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author  Kunal Gupta
 */


@Service
public class FileServiceImpl implements FileService {

    @Autowired
    EmployeeRepository employeeRepository;

    // Store File Data to Database
    public void store(MultipartFile file) {
        try {
            List<Employee> lstCustomers = ExcelUtils.parseExcelFile(file.getInputStream());
            // Save Customers to DataBase
            employeeRepository.saveAll(lstCustomers);
        } catch (IOException e) {
            throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
    }
}
