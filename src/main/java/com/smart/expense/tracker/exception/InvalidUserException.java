package com.smart.expense.tracker.exception;

public class InvalidUserException extends RuntimeException{

    public InvalidUserException(String msg){
        super(msg);
    }
}
