package main.persistance.exceptions;

public class MaxConnectionsReachedException extends Exception {
    public MaxConnectionsReachedException() { super(); }
    public MaxConnectionsReachedException(String message) { super(message); }
}
