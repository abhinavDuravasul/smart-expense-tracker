package com.smart.expense.tracker.service.impl;

import com.smart.expense.tracker.dto.ExpenseRequest;
import com.smart.expense.tracker.entity.Expense;

import java.util.List;

public interface ExpenseService {

    Expense saveExpense(ExpenseRequest expenseRequest);

    List<Expense> getAllExpenses();

    void deleteExpense(Long id);
}
