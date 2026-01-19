package com.example.lendflowbackend.controller;

import com.example.lendflowbackend.model.Loan;
import com.example.lendflowbackend.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }

    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        return loanService.createLoan(loan);
    }

    @PutMapping("/{loanId}/interest")
    public ResponseEntity<?> updateInterestRate(
            @PathVariable String loanId,
            @RequestParam double newRate) {

        return loanService.updateInterestRate(loanId, newRate);
    }

    // ===== NOTES ENDPOINTS =====

    @GetMapping("/{loanId}/notes")
    public ResponseEntity<?> getNotesForLoan(@PathVariable String loanId) {
        return loanService.getNotesForLoan(loanId);
    }

    @PostMapping("/{loanId}/notes")
    public ResponseEntity<?> addNoteToLoan(
            @PathVariable String loanId,
            @RequestBody NoteRequest request) {

        return loanService.addNoteToLoan(loanId, request);
    }

    @PutMapping("/{loanId}/status")
    public ResponseEntity<?> updateLoanStatus(
            @PathVariable String loanId,
            @RequestParam String status) {

        return loanService.updateLoanStatus(loanId, status);
    }


}
