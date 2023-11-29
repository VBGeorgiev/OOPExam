package com.oopexam.services;

import com.oopexam.database.Reader;
import com.oopexam.database.Writer;
import com.oopexam.model.Employee;
import com.oopexam.validate.ValidateCommands;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class StaffService extends Service{
    private HashMap<Integer, Employee> employeeList;

    public StaffService(Reader reader, Writer writer) {
        super(reader, writer);
        this.employeeList = super.reader.read();
    }

    public HashMap<Integer, Employee> getEmployeeList() {
        return employeeList;
    }

    public void viewAll() {
        this.employeeList.forEach((key, empl) -> empl.view());
    }

    public void viewAllActive() {
        this.employeeList.forEach((key, empl) -> {
            if(empl.getEndDate() == null){
                empl.view();
            }

        });

    }

    public void add() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter employee id (an integer): ");
        String emplId = scan.nextLine();
        int id = ValidateCommands.parseNum(1, emplId, "Please try again entering an integer", scan);
        if(!this.employeeList.containsKey(id)) {
            System.out.println("Enter employee name: ");
            String name = scan.nextLine();
            System.out.println("Enter employee role: ");
            String role = scan.nextLine();
            System.out.println("Enter employee department: ");
            String department = scan.nextLine();
            System.out.println("Enter employee salary: ");
            String emplSalary = scan.nextLine();
            double salary = ValidateCommands.parseNum(1.00, emplSalary, "Please try again entering employee salary as double type", scan);
            Employee employee = new Employee(id, name, department, role, salary);
            this.employeeList.put(id, employee);
        } else {
            System.out.println("Employee id already exist. Please try again.");
        }

    }

    public void saveEmployeeList() {
        super.writer.write(this.employeeList);
    }

    public void edit(String command) {
        Scanner scan = new Scanner(System.in);
        String[] commandStrings = command.split(" ");
        int id = Integer.parseInt(commandStrings[1]);
        if(this.employeeList.containsKey(id)) {
            System.out.println("Would you like to edit employee name (if yes, enter yes): ");
            String editName = scan.nextLine();
            if(editName.equalsIgnoreCase("yes")) {
                System.out.println("Enter new employee name: ");
                String newName = scan.nextLine();
                if(!newName.isEmpty()){
                    this.employeeList.get(id).setName(newName);
                }

            }

            System.out.println("Would you like to edit employee role (if yes, enter yes): ");
            String editRole = scan.nextLine();
            if(editRole.equalsIgnoreCase("yes")) {
                System.out.println("Enter new employee role: ");
                String newRole = scan.nextLine();
                if(!newRole.isEmpty()){
                    this.employeeList.get(id).setRole(newRole);
                }

            }

            System.out.println("Would you like to edit employee department (if yes, enter yes): ");
            String editDepartment = scan.nextLine();
            if(editDepartment.equalsIgnoreCase("yes")) {
                System.out.println("Enter new employee department: ");
                String newDepartment = scan.nextLine();
                if(!newDepartment.isEmpty()){
                    this.employeeList.get(id).setDepartment(newDepartment);
                }

            }

            System.out.println("Would you like to edit employee salary (if yes, enter yes): ");
            String editSalary = scan.nextLine();
            if(editName.equalsIgnoreCase("yes")) {
                System.out.println("Enter new employee salary: ");
                String newSalary = scan.nextLine();
                double salary = ValidateCommands.parseNum(1.0, newSalary, "Please try again new double value", scan);
                this.employeeList.get(id).setSalary(salary);
            }

        } else {
            System.out.println("Employee id not found");
        }

    }

    public void fire(String command) {
        String[] commandStrings = command.split(" ");
        int id = Integer.parseInt(commandStrings[1]);
        if(this.employeeList.containsKey(id)) {
            this.employeeList.get(id).setEndDate(LocalDate.now());
            this.employeeList.get(id).view();
            System.out.println("Above mentioned employee has been fired");
        } else {
            System.out.println("Employee id not found");
        }

    }

    public void searchEmployeeById(String command) {
        String[] commandStrings = command.split(" ");
        int id = Integer.parseInt(commandStrings[2]);
        if(this.employeeList.containsKey(id)) {
            this.employeeList.get(id).view();
        } else {
            System.out.println("Employee id not found");
        }

    }

    public void searchEmployeeByName(String command) {
        String[] commandStrings = command.split(" ");
        String name = commandStrings[2];
        this.employeeList.forEach((key, empl) -> {
            if(empl.getName().contains(name)) {
                this.employeeList.get(key).view();
            }

        });

//        this.employeeList.entrySet().stream().filter(e -> e.)

    }

}
