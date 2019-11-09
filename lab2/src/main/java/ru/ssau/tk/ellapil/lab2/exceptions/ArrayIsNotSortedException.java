package ru.ssau.tk.ellapil.lab2.exceptions;

public class ArrayIsNotSortedException extends RuntimeException {
    private static final long serialVersionUID = 5582929137709040869L;

    public ArrayIsNotSortedException() {
    }

    public ArrayIsNotSortedException(String mess) {
        super(mess);
    }
}
