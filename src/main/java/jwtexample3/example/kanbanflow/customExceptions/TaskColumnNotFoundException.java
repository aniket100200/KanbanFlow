package jwtexample3.example.kanbanflow.customExceptions;

public class TaskColumnNotFoundException extends RuntimeException{
    public TaskColumnNotFoundException(String message) {
        super(message);
    }
}
