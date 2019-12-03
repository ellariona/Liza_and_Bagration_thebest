package ru.ssau.tk.ellapil.lab2.concurrent;

import ru.ssau.tk.ellapil.lab2.functions.TabulatedFunction;

public class MultiplyingTask implements Runnable {
    private TabulatedFunction tabulatedFunction;

    public MultiplyingTask(TabulatedFunction tabulatedFunction) {
        this.tabulatedFunction = tabulatedFunction;
    }

    @Override
    public void run() {
        for (int i = 0; i < tabulatedFunction.getCount(); i++) {
            tabulatedFunction.setY(i, 2 * tabulatedFunction.getY(i));
        }
        System.out.println("The " + Thread.currentThread().getName() + " has completed execution");
    }
}

