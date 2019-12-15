package ru.ssau.tk.ellapil.lab2.concurrent;

import ru.ssau.tk.ellapil.lab2.functions.TabulatedFunction;

public class MultiplyingTask implements Runnable {
    private final TabulatedFunction tabulatedFunction;
    private boolean isCompleted;

    public MultiplyingTask(TabulatedFunction tabulatedFunction) {
        this.tabulatedFunction = tabulatedFunction;
    }

    @Override
    public void run() {
        for (int i = 0; i < tabulatedFunction.getCount(); i++) {
            synchronized (tabulatedFunction) {
                tabulatedFunction.setY(i, 2 * tabulatedFunction.getY(i));
            }
        }
        System.out.println("The " + Thread.currentThread().getName() + " has completed execution");
        isCompleted = true;
    }
    public boolean isCompleted() {
        return isCompleted;
    }
}

