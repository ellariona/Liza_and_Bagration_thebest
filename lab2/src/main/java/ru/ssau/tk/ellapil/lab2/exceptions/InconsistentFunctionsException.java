package ru.ssau.tk.ellapil.lab2.exceptions;

public class InconsistentFunctionsException extends RuntimeException {
    public InconsistentFunctionsException() {
    }

    public InconsistentFunctionsException(String mess) {
        super(mess);
    }
}
