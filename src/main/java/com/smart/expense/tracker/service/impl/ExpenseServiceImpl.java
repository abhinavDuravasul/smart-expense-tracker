package com.smart.expense.tracker.service.impl;

import com.smart.expense.tracker.dto.ExpenseRequest;
import com.smart.expense.tracker.entity.Expense;
import com.smart.expense.tracker.entity.User;
import com.smart.expense.tracker.exception.UsernameNotFoundException;
import com.smart.expense.tracker.repository.ExpenseRepository;
import com.smart.expense.tracker.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository, UserRepository userRepository, ModelMapper mapper) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    /**
     * @param expenseRequest
     * @return
     */
    @Override
    public Expense saveExpense(ExpenseRequest expenseRequest) {

        Expense expense= mapper.map(expenseRequest, Expense.class);
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentLoginUser = getCurrentUserByName(currentUser);
        expense.setUser(currentLoginUser);
        return expenseRepository.save(expense);
    }


    public List<Expense> getAllExpenses(){
         //@Query("SELECT e FROM Expense e ORDER BY e.id ASC")
        return expenseRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public void deleteExpense(Long id){
        expenseRepository.deleteById(id);
    }

    private User getCurrentUserByName(String userName){
        return userRepository.findByUserName(userName).orElseThrow(()->
                new UsernameNotFoundException("User not Found"));
    }

}
