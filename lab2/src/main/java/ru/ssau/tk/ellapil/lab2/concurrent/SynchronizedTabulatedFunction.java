package ru.ssau.tk.ellapil.lab2.concurrent;

import org.jetbrains.annotations.NotNull;
import ru.ssau.tk.ellapil.lab2.functions.Point;
import ru.ssau.tk.ellapil.lab2.functions.TabulatedFunction;
import ru.ssau.tk.ellapil.lab2.operations.TabulatedFunctionOperationService;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SynchronizedTabulatedFunction implements TabulatedFunction {
    TabulatedFunction function;

    public SynchronizedTabulatedFunction(TabulatedFunction function) {
        this.function = function;
    }

    @Override
    public int getCount() {
        synchronized (function) {
            return function.getCount();
        }
    }

    @Override
    public double getX(int index) {
        synchronized (function) {
            return function.getX(index);
        }
    }

    @Override
    public double getY(int index) {
        synchronized (function) {
            return function.getY(index);
        }
    }

    @Override
    public void setY(int index, double value) {
        synchronized (function) {
            function.setY(index, value);
        }
    }

    @Override
    public int indexOfX(double x) {
        synchronized (function) {
            return function.indexOfX(x);
        }
    }

    @Override
    public int indexOfY(double y) {
        synchronized (function) {
            return function.indexOfY(y);
        }
    }

    @Override
    public double leftBound() {
        synchronized (function) {
            return function.leftBound();
        }
    }

    @Override
    public double rightBound() {
        synchronized (function) {
            return function.rightBound();
        }
    }

    @NotNull
    @Override
    public Iterator<Point> iterator() {
        synchronized (function) {
            Point[] copy = TabulatedFunctionOperationService.asPoints(function);
            return new Iterator<>() {
                int i = 0;

                @Override
                public boolean hasNext() {
                    return i != copy.length;
                }

                @Override
                public Point next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    } else {
                        return new Point(copy[i].x, copy[i++].y);
                    }
                }
            };
        }
    }

    @Override
    public double apply(double x) {
        synchronized (function) {
            return function.apply(x);
        }
    }

    public interface Operation<T> {
        T apply(SynchronizedTabulatedFunction synchronizedTabulatedFunction);
    }

    public synchronized <T> T doSynchronously(Operation<? extends T> operation) {
        return operation.apply(this);
    }
}
