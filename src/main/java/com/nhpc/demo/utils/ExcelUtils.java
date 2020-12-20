package com.nhpc.demo.utils;

import com.nhpc.demo.model.emp.Employee;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author  Kunal Gupta
 */


public class ExcelUtils {


    public static List<Employee> parseExcelFile(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet("Employee");
            Iterator<Row> rows = sheet.iterator();

            List<Employee> employees = new ArrayList<Employee>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Employee emp = new Employee();

                int cellIndex = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    if (cellIndex == 0) { // Login
                        emp.setLogin(currentCell.getStringCellValue());
                    } else if (cellIndex == 1) { // Name
                        emp.setLogin(currentCell.getStringCellValue());
                    } else if (cellIndex == 2) { // Salary
						emp.setLogin(currentCell.getStringCellValue());
					}else if (cellIndex == 3) { // Start Date
                    	Date date= DateUtil.getJavaDate((double) currentCell.getNumericCellValue());
						emp.setDate(date);
                    }

                    cellIndex++;
                }

				employees.add(emp);
            }

            // Close WorkBook
            workbook.close();

            return employees;
        } catch (IOException e) {
            throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
    }
}