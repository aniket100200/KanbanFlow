package jwtexample3.example.kanbanflow.customExceptions;

public class PasswordNotFoundException extends Exception {
    public PasswordNotFoundException(String message) {
        super(message);
    }
}
