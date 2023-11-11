package com.oopexam.services;

import com.oopexam.database.Reader;
import com.oopexam.database.Writer;
import com.oopexam.model.Employee;
import com.oopexam.validate.ValidateCommands;

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
        this.employeeList.forEach((key, empl) ->
                System.out.println(empl.getId() + ", " +
                        empl.getName() + ", " +
                        empl.getStartDate() + ", " +
                        empl.getEndDate() + ", " +
                        empl.getDepartment() + ", " +
                        empl.getRole() + ", " +
                        empl.getSalary()
                ));
    }

    public void viewAllActive() {

    }

    public void add() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter employee id (an integer): ");
        String emplId = scan.nextLine();
        int id = ValidateCommands.parseNum(1, emplId, "Please try again entering an integer", scan);
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
    }

    public void saveEmployeeList() {
        super.writer.write(this.employeeList);
    }

    public void searchEmployeeById(String command) {
        String[] commandStrings = command.split(" ");
        int id = Integer.parseInt(commandStrings[2]);
        if(this.employeeList.containsKey(id)) {
            System.out.println(id + ", " +
                    this.employeeList.get(id).getName() + ", " +
                    this.employeeList.get(id).getStartDate() + ", " +
                    this.employeeList.get(id).getEndDate() + ", " +
                    this.employeeList.get(id).getDepartment() + ", " +
                    this.employeeList.get(id).getRole() + ", " +
                    this.employeeList.get(id).getSalary());
        } else {
            System.out.println("Employee id not found");
        }

    }

}
