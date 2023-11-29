package com.oopexam.management;

import com.oopexam.database.Reader;
import com.oopexam.database.Writer;
import com.oopexam.services.Service;
import com.oopexam.services.StaffService;
import com.oopexam.validate.ValidateCommands;

import java.util.Scanner;

public class StaffManagementApp {
    public static void main() {
// implement fileReader/fileWriter to handle saving into csv/json
        Reader reader = new Reader();
        Writer writer = new Writer();
        Service service = new StaffService(reader, writer);
        Manager manager = new StaffManager(service);
        System.out.println("Welcome to Staff Management System");
        displayCommands();
        boolean isRunning = true;
        while (isRunning) {
            String command = getCommands();
            if(ValidateCommands.validateCommnands(command)) {
                manager.execute(command);
            } else {
                System.out.println("Command not valid. Please try again");
            }

            if(command.equals("Save & Exit")) {
                isRunning = false;
            } else {
                System.out.println("Please enter another command: ");
            }

        }

    }

    private static void displayCommands() {

        System.out.println("========================================");
        System.out.println("Please select a command:");
        System.out.println("========================================");
        System.out.println("Add employee (enter: Add Employee): ");
        System.out.println("Edit employee data (enter: Edit and employeeId): ");
        System.out.println("List all active employees (enter: List employees): ");
        System.out.println("List all employees (enter: List all employees): ");
        System.out.println("Search employees by department (enter: Search Department departmentName): ");
        System.out.println("Search employee by id (enter: Search Id and employeeId): ");
        System.out.println("Search employee by name (enter: Search Name and employeeName): ");
        System.out.println("Fire an employee (enter: Fire and employeeId): ");
        System.out.println("Save and exit the app (enter: Save & Exit): ");
        System.out.println("========================================");
    }

    private static String getCommands() {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        return command;
    }
}
