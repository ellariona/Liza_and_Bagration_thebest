package ru.ssau.tk.ellapil.lab2.exceptions;

public class DifferentLengthOfArraysException extends RuntimeException {
    private static final long serialVersionUID = 2085068655940036483L;

    public DifferentLengthOfArraysException() {
    }

    public DifferentLengthOfArraysException(String mess) {
        super(mess);
    }
}
