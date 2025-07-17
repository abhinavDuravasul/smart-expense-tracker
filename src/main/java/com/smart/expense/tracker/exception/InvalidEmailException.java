package com.smart.expense.tracker.exception;

public class InvalidEmailException extends RuntimeException{

    public InvalidEmailException (String msg){
        super(msg);
    }

}
