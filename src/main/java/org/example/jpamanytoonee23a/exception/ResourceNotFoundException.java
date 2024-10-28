package org.example.jpamanytoonee23a.exception;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    //hej er en konstruk
    public ResourceNotFoundException(String message) {
        super(message);
    }

}
