package main.exceptions;

public class InsufficientCash extends RuntimeException {
    public InsufficientCash(String message) {
        super(message);
    }
}
