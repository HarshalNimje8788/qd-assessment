package com.grocery.services.Grocery.exception;

public class groceryItemNotFoundException extends RuntimeException{
    public groceryItemNotFoundException(){
        super("Grocery team is not avilable !!");
    }
    public groceryItemNotFoundException(String message){
        super(message);
    }
}
