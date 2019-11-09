package ru.ssau.tk.ellapil.lab2.exceptions;

public class InconsistentFunctionsException extends RuntimeException {
    private static final long serialVersionUID = -1499426996851068209L;

    public InconsistentFunctionsException() {
    }

    public InconsistentFunctionsException(String mess) {
        super(mess);
    }
}
