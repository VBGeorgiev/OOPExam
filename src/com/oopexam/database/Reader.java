package com.oopexam.database;

import com.oopexam.model.Employee;
import com.oopexam.utility.Constants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Reader implements Readable{

    @Override
    public HashMap<Integer, Employee> read() {
        String line = "one";
        HashMap<Integer, Employee> employeeList = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try (BufferedReader br = new BufferedReader(new FileReader(Constants.path + "employeeList.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] item = line.split("\\s*,\\s*");
                Employee tempEmployee = new Employee();
                int id = Integer.parseInt(item[0]);
                tempEmployee.setId(id);
                tempEmployee.setName(item[1]);
                if(!item[2].equals("null")) {
                    tempEmployee.setStartDate(LocalDate.parse(item[2], formatter));
                } else {
                    tempEmployee.setStartDate(null);
                }

                if(!item[3].equals("null")) {
                    tempEmployee.setEndDate(LocalDate.parse(item[3], formatter));
                } else {
                    tempEmployee.setEndDate(null);
                }

                tempEmployee.setRole(item[4]);
                tempEmployee.setDepartment(item[5]);
                tempEmployee.setSalary(Double.parseDouble(item[6]));
                employeeList.put(id, tempEmployee);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return employeeList;
    }

}

