package jwtexample3.example.kanbanflow.customExceptions;

public class BoardNotFoundException extends RuntimeException{
    public BoardNotFoundException(String message) {
        super(message);
    }
}
