package com.example.lendflowbackend.repository;

import com.example.lendflowbackend.model.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends MongoRepository<Loan, String> {

    // Spring auto-implements this
    Loan findByLoanId(String loanId);
}
