package com.iche.task_two.exception;



public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException (String massage){
        super(massage);
    }
}
