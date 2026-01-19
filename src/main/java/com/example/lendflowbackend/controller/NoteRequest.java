package com.example.lendflowbackend.controller;

public class NoteRequest {

    private String employeeId;
    private String department;
    private String category;
    private String message;

    public String getEmployeeId() {
        return employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public String getCategory() {
        return category;
    }

    public String getMessage() {
        return message;
    }
}

