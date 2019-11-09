package ru.ssau.tk.ellapil.lab2.concurrent;

import ru.ssau.tk.ellapil.lab2.functions.TabulatedFunction;

public class ReadTask implements Runnable {
    private TabulatedFunction tabulatedFunction;

    ReadTask(TabulatedFunction tabulatedFunction) {
        this.tabulatedFunction = tabulatedFunction;
    }

    @Override
    public void run() {
        for (int i = 0; i < tabulatedFunction.getCount(); i++) {
            System.out.printf("After read: i = %dx = %f, y = %f\n", i, tabulatedFunction.getX(i), tabulatedFunction.getY(i));
        }
    }
}