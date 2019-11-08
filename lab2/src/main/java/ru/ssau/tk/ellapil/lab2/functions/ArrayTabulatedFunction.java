package ru.ssau.tk.ellapil.lab2.functions;

import com.sun.jdi.InternalException;
import ru.ssau.tk.ellapil.lab2.exceptions.InterpolationException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class ArrayTabulatedFunction extends AbstractTabulatedFunction implements Serializable,Insertable {
    private static final long serialVersionUID = 7689935679985602927L;
    private double[] xValues;
    private double[] yValues;
    private int count;

    public ArrayTabulatedFunction(double[] xValues, double[] yValues) {
        checkLengthIsTheSame(xValues, yValues);
        checkSorted(xValues);
        count = xValues.length;
        this.xValues = Arrays.copyOf(xValues, count);
        this.yValues = Arrays.copyOf(yValues, count);
    }

    public ArrayTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        this.count = count;
        if (xFrom > xTo) {
            double tmp = xFrom;
            xFrom = xTo;
            xTo = tmp;
        }
        xValues = new double[count];
        yValues = new double[count];

        double step = (xTo - xFrom) / (count - 1);
        double interim = xFrom;
        if (xFrom == xTo) {
            double funcXFrom = source.apply(xFrom);
            for (int i = 0; i < count; i++) {
                xValues[i] = xFrom;
                yValues[i] = funcXFrom;
                interim += step;
            }
        } else {
            for (int i = 0; i < count; i++) {
                xValues[i] = interim;
                yValues[i] = source.apply(interim);
                interim += step;
            }

        }
    }

    @Override
    public void insert(double x, double y){
        if (this.indexOfX(x) != -1){
            setY(indexOfX(x),y);
        }
        else {
            double[] newXValues = new double[count + 1];
            double[] newYValues = new double[count + 1];
            if(floorIndexOfX(x) == 0) {
                System.arraycopy(xValues, 0, newXValues, 1, count);
                System.arraycopy(yValues, 0, newYValues, 1, count);
                newXValues[0] = x;
                newYValues[0] = y;
            }
            if(floorIndexOfX(x) == count) {
                System.arraycopy(xValues, 0, newXValues, 0, count);
                System.arraycopy(yValues, 0, newYValues, 0, count);
                newXValues[count + 1] = x;
                newYValues[count + 1] = y;
            }
            else{
                int i = floorIndexOfX(x);
                System.arraycopy(xValues, 0, newXValues, 0, i + 1);
                System.arraycopy(xValues, i + 1, newXValues, i + 2, count - i - 1);
                newXValues[i + 1] = x;
                System.arraycopy(yValues, 0, newYValues, 0, i + 1);
                System.arraycopy(yValues, i + 1, newYValues, i + 2, count - i - 1);
                newYValues[i + 1] = y;
            }
            count++;
            this.xValues = newXValues;
            this.yValues = newYValues;
        }
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public double getX(int index) {
        return xValues[index];
    }

    @Override
    public double getY(int index) {
        return yValues[index];
    }

    @Override
    public void setY(int index, double value) {
        yValues[index] = value;
    }

    @Override
    public double leftBound() {
        return xValues[0];
    }

    @Override
    public double rightBound() {
        return xValues[count - 1];
    }

    @Override
    public int indexOfX(double x) {
        int i;
        for (i = 0; i < count; i++) {
            if (xValues[i] == x) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int indexOfY(double y) {
        int i;
        for (i = 0; i < count; i++) {
            if (yValues[i] == y) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected int floorIndexOfX(double x) {
        if (x < leftBound()) {
            return 0;
        }
        for (int i = 0; i < count; i++) {
            if (xValues[i] > x) {
                return i - 1;
            }
        }
        return count;
    }

    @Override
    protected double extrapolateLeft(double x) {
        if (count == 1) {
            return yValues[0];
        }
        return interpolate(x, xValues[0], xValues[1], yValues[0], yValues[1]);
    }

    @Override
    protected double extrapolateRight(double x) {
        if (count == 1) {
            return yValues[0];
        }
        return interpolate(x, xValues[count - 2], xValues[count - 1], yValues[count - 2], yValues[count - 1]);
    }

    @Override
    protected double interpolate(double x, int floorIndex) {
        if (!(xValues[floorIndex] < x && x < xValues[floorIndex + 1])) {
            throw new InterpolationException();
        }
        if (count == 1) {
            return yValues[0];
        }
        return interpolate(x, xValues[floorIndex], xValues[floorIndex + 1], yValues[floorIndex], yValues[floorIndex + 1]);
    }


    public Iterator<Point> iterator() {
        var iterator = new Iterator<Point>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                if (i > count - 1) {
                    return false;
                }
                return true;
            }

            @Override
            public Point next() {
                if (hasNext()) {
                    if (i == count) {
                        throw new NoSuchElementException();
                    }
                    return new Point(xValues[i], yValues[i++]);
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
        return iterator;
    }
}
