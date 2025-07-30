package com.smart.expense.tracker.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter

public class ExpenseRequest {

    @NotBlank(message ="ExpenseRequest title cannot be empty")
    @Size(max=100)
    private String title;

    private String amount;

    private String category;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Size(max = 12)
    private String paymentMethod;

    private String notes;

}
