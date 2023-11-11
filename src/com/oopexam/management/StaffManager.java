package com.oopexam.management;

import com.oopexam.services.Service;
import com.oopexam.services.StaffService;

public class StaffManager extends Manager{
    private String command;
    private StaffService staffService;
    public StaffManager(Service service) {
        super(service);
        this.staffService = new StaffService(super.getService().getReader(), super.getService().getWriter());
    }

    @Override
    public void execute(String command) {
        if(command.equals("List employees")) {
            this.viewEmployee();
        } else if(command.equals("Add Employee")) {
            this.staffService.add();
        } else if(command.equals("Save & Exit")) {
            this.staffService.saveEmployeeList();
        } else if(command.matches("Search Id [0-9]*")) {
            this.staffService.searchEmployeeById(command);
        }

    }

    public void viewEmployee() {
        this.staffService.viewAll();
    }

    public void viewActiveEmployee() {
    }
}
