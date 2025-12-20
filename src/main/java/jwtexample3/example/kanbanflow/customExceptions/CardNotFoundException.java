package jwtexample3.example.kanbanflow.customExceptions;

public class CardNotFoundException extends RuntimeException{
    public CardNotFoundException(String message) {
        super(message);
    }
}
