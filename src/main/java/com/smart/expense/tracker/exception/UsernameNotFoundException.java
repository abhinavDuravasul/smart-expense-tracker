package com.smart.expense.tracker.exception;

public class UsernameNotFoundException extends RuntimeException{

    public UsernameNotFoundException(String msg){
        super(msg);
    }
}
