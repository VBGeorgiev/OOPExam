package com.oopexam.management;

import com.oopexam.services.Service;

public abstract class Manager {
    public Service service;

    public Manager(Service service) {
        this.service = service;
    }

    public abstract void execute(String command);

    public Service getService() {
        return this.service;
    }
}
