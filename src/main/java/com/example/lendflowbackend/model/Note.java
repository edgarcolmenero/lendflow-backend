package com.example.lendflowbackend.model;

import java.time.LocalDateTime;

public class Note {

    private String noteId;
    private String loanId;

    private String employeeId;
    private String department;
    private String category;
    private String message;

    private LocalDateTime createdAt;

    // REQUIRED for Mongo / Jackson
    public Note() {
    }

    public Note(String noteId,
                String loanId,
                String employeeId,
                String department,
                String category,
                String message) {

        this.noteId = noteId;
        this.loanId = loanId;
        this.employeeId = employeeId;
        this.department = department;
        this.category = category;
        this.message = message;
        this.createdAt = LocalDateTime.now();
    }

    public String getNoteId() {
        return noteId;
    }

    public String getLoanId() {
        return loanId;
    }

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
