package ru.ssau.tk.ellapil.lab2.concurrent;

import ru.ssau.tk.ellapil.lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.TabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.UnitFunction;

import java.util.ArrayList;
import java.util.List;

public class MultiplyingTaskExecutor {
    public static void main(String[] args) {
        TabulatedFunction listTabulatedFunction = new LinkedListTabulatedFunction(new UnitFunction(), 1, 1000, 1001);
        List<Thread> threadList = new ArrayList<>();
        List<MultiplyingTask> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MultiplyingTask task = new MultiplyingTask(listTabulatedFunction);
            threadList.add(new Thread(task));
            tasks.add(task);
        }
        for (Thread t : threadList) {
            t.start();
        }

        while (!tasks.isEmpty()) {
            tasks.removeIf(MultiplyingTask::isCompleted);
        }

        System.out.println(listTabulatedFunction);
    }
}

