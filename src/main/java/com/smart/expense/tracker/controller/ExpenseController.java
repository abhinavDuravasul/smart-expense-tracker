package com.smart.expense.tracker.controller;

import com.smart.expense.tracker.dto.ExpenseRequest;
import com.smart.expense.tracker.entity.Expense;
import com.smart.expense.tracker.service.impl.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/expenses")
@RestController
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
//POST /api/expenses

    @PostMapping
    public ResponseEntity<Expense> addExpense(@Valid @RequestBody ExpenseRequest request){
       Expense  savedExpense = expenseService.saveExpense(request);
       return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }

    @GetMapping("/getall")

    public ResponseEntity<List<Expense>> getAllExpenses(){
       return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);
       return ResponseEntity.noContent().build();
    }
}
