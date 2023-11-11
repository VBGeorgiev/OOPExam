package com.oopexam.database;

import com.oopexam.model.Employee;
import com.oopexam.utility.Constants;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class Writer implements Writable{
    @Override
    public void write(HashMap<Integer, Employee> employeeList) {
        try (PrintWriter out = new PrintWriter(new FileWriter(Constants.path + "employeeList.csv"))) {
            employeeList.keySet().stream().forEach(key -> out.println(key + ", " +
                    employeeList.get(key).getName() + ", " +
                    employeeList.get(key).getStartDate() + ", " +
                    employeeList.get(key).getEndDate() + ", " +
                    employeeList.get(key).getDepartment() + ", " +
                    employeeList.get(key).getRole() + ", " +
                    employeeList.get(key).getSalary()));
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
