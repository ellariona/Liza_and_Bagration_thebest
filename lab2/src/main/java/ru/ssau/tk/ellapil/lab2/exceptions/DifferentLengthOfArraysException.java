package ru.ssau.tk.ellapil.lab2.exceptions;

public class DifferentLengthOfArraysException extends RuntimeException {
    public DifferentLengthOfArraysException() {
    }

    public DifferentLengthOfArraysException(String mess) {
        super(mess);
    }
}
