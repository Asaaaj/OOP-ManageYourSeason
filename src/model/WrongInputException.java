package model;

public class WrongInputException extends Exception{
    public WrongInputException() {
        System.out.println("Wrong Username or Password");
    }
}
