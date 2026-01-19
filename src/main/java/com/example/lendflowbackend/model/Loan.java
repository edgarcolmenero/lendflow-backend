package com.example.lendflowbackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "loans")
public class Loan {

    @Id
    private String loanId;

    private String customerName;
    private String loanType;
    private double amount;
    private double interestRate;
    private String status;

    private List<Note> notes = new ArrayList<>();

    // REQUIRED for Mongo / Jackson
    public Loan() {
    }

    public Loan(String loanId, String customerName, String loanType,
                double amount, double interestRate, String status) {
        this.loanId = loanId;
        this.customerName = customerName;
        this.loanType = loanType;
        this.amount = amount;
        this.interestRate = interestRate;
        this.status = status;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void addNote(Note note) {
        this.notes.add(note);
    }
}
