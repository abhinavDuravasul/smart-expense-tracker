package com.smart.expense.tracker.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


@Entity
@Table(name ="exp_expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message ="Title cannot be empty")
    @Size(max = 100, message = "Title can't exceed 100 characters")
    @Column(name = "title")
    private String title;

    @NotNull(message = "Amount cannot be null")
    @Column(name = "amount")
    private String amount;

    @Size(max=10, message = "Category characters cannot exceed 12 chars")
    @Column(name = "category")
    private String category;


    @PastOrPresent(message=" Expense date cannot be in the future")
    @Column(name = "expense_date")
    private LocalDate date;

    @Size(max=12, message ="Payment method cannot exceed 12 characters")
    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name  ="notes_info")
    private String notes;


}
