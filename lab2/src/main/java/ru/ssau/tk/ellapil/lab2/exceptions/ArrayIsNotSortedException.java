package ru.ssau.tk.ellapil.lab2.exceptions;

public class ArrayIsNotSortedException extends RuntimeException {
    public ArrayIsNotSortedException() {
    }

    public ArrayIsNotSortedException(String mess) {
        super(mess);
    }
}
