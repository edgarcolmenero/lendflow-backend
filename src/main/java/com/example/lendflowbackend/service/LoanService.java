package com.example.lendflowbackend.service;

import com.example.lendflowbackend.model.Loan;
import com.example.lendflowbackend.model.Note;
import com.example.lendflowbackend.repository.LoanRepository;
import com.example.lendflowbackend.controller.NoteRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    // ================= LOANS =================

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public ResponseEntity<?> updateInterestRate(String loanId, double newRate) {

        Loan loan = loanRepository.findByLoanId(loanId);

        if (loan == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Loan not found");
        }

        if ("DELINQUENT".equalsIgnoreCase(loan.getStatus())) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Cannot update interest rate on a delinquent loan");
        }

        loan.setInterestRate(newRate);
        loanRepository.save(loan);

        return ResponseEntity.ok(loan);
    }

    public ResponseEntity<?> updateLoanStatus(String loanId, String newStatus) {

        Loan loan = loanRepository.findByLoanId(loanId);

        if (loan == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Loan not found");
        }

        if ("CLOSED".equalsIgnoreCase(loan.getStatus())) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Closed loans cannot be modified");
        }

        if ("DELINQUENT".equalsIgnoreCase(loan.getStatus())
                && "ACTIVE".equalsIgnoreCase(newStatus)) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Delinquent loans require review before reactivation");
        }

        loan.setStatus(newStatus);
        loanRepository.save(loan);

        return ResponseEntity.ok(loan);
    }

    // ================= NOTES =================

    public ResponseEntity<?> getNotesForLoan(String loanId) {

        Loan loan = loanRepository.findByLoanId(loanId);

        if (loan == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Loan not found");
        }

        return ResponseEntity.ok(loan.getNotes());
    }

    public ResponseEntity<?> addNoteToLoan(String loanId, NoteRequest request) {

        Loan loan = loanRepository.findByLoanId(loanId);

        if (loan == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Loan not found");
        }

        if (request.getEmployeeId() == null || request.getEmployeeId().isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Employee ID is required");
        }

        Note note = new Note(
                UUID.randomUUID().toString(),
                loanId,
                request.getEmployeeId(),
                request.getDepartment(),
                request.getCategory(),
                request.getMessage()
        );

        loan.addNote(note);
        loanRepository.save(loan);

        return ResponseEntity.status(HttpStatus.CREATED).body(note);
    }
}
