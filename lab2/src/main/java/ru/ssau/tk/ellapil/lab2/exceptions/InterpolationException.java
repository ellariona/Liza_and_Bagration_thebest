package ru.ssau.tk.ellapil.lab2.exceptions;

public class InterpolationException extends RuntimeException {
    private static final long serialVersionUID = -4208702242331024725L;

    public InterpolationException() {
    }

    public InterpolationException(String mess) {
        super(mess);
    }
}
