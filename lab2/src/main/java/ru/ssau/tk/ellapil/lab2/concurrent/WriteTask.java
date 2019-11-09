package ru.ssau.tk.ellapil.lab2.concurrent;

import ru.ssau.tk.ellapil.lab2.functions.TabulatedFunction;

public class WriteTask implements Runnable {
    private TabulatedFunction tabulatedFunction;
    private double value;

    WriteTask(TabulatedFunction tabulatedFunction, double value) {
        this.value = value;
        this.tabulatedFunction = tabulatedFunction;
    }

    @Override
    public void run() {
        for (int i = 0; i < tabulatedFunction.getCount(); i++) {
            tabulatedFunction.setY(i, value);
            System.out.printf("Writing for index %d complete\n", i);
        }
    }
}