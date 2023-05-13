package model;

public class NoInputException extends Exception{
    public NoInputException() {
        System.out.println("Empty Username or Password Input");
    }
}
