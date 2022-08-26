package com.employee.employeemanager.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String string) {
       super(string);
    }

}
