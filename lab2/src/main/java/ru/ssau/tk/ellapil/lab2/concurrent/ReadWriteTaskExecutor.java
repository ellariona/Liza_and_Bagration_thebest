package ru.ssau.tk.ellapil.lab2.concurrent;

import ru.ssau.tk.ellapil.lab2.functions.ConstantFunction;
import ru.ssau.tk.ellapil.lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.TabulatedFunction;

public class ReadWriteTaskExecutor {
    public static void main(String[] args) {
        TabulatedFunction listTabulatedFunction = new LinkedListTabulatedFunction(new ConstantFunction(-3), 1, 500, 500);
        Thread readThread = new Thread(new ReadTask(listTabulatedFunction));
        Thread writeThread = new Thread(new WriteTask(listTabulatedFunction, 4));
        writeThread.start();
        readThread.start();
    }
}
