package com.oopexam.database;

import com.oopexam.model.Employee;

import java.util.HashMap;

public interface Writable {
    public void write(HashMap<Integer, Employee> employeeList);
}
