package ru.ssau.tk.ellapil.lab2.functions;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class MockTabulatedFunction extends AbstractTabulatedFunction {
    final double x0 = 1;
    final double x1 = 3;
    final double y0 = 1;
    final double y1 = 4;

    @Override
    protected int floorIndexOfX(double x) {
        if (x < x0) {
            return 0;
        } else if (x > x1) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    protected double extrapolateLeft(double x) {
        return super.interpolate(x, x0, x1, y0, y1);
    }

    @Override
    protected double extrapolateRight(double x) {
        return super.interpolate(x, x0, x1, y0, y1);
    }

    @Override
    protected double interpolate(double x, int floorIndex) {
        return super.interpolate(x, x0, x1, y0, y1);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public double getX(int index) {
        if (index == 0) {
            return x0;
        } else if (index == 1) {
            return x1;
        } else {
            return -1;
        }
    }

    @Override
    public double getY(int index) {
        if (index == 0) {
            return y0;
        } else
            return y1;
    }


    @Override
    public void setY(int index, double value) {

    }

    @Override
    public int indexOfX(double x) {
        if (x == x0) {
            return 0;
        } else if (x == x1) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public int indexOfY(double y) {
        return 0;
    }

    @Override
    public double leftBound() {
        return x0;
    }

    @Override
    public double rightBound() {
        return x1;
    }

    @NotNull
    @Override
    public Iterator<Point> iterator() {
        return null;
    }
}

