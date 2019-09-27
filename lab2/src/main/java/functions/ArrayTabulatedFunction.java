package functions;

import java.util.Arrays;

abstract class ArrayTabulatedFunction extends AbstractTabulatedFunction
{
    private double[] xValues;
    private double[] yValues;
    private int count;

    public ArrayTabulatedFunction(double[] xValues, double[] yValues) {
        this.xValues = Arrays.copyOf(xValues, count);
        this.yValues = Arrays.copyOf(yValues, count);
        this.count = xValues.length;
    }

    ArrayTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
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
    public int getCount() { return count; }
    public double getX(int index) {return xValues[index];}
    public double getY(int index) {return yValues[index];}
    public void setY(int index, double value) {yValues[index] = value;}
    public double leftBound() {return xValues[0];}
    public double rightBound() {return xValues[count-1];}

    public int indexOfX(double x)
    {
        int i;
        for (i = 0; i < count; i++) {
            if (xValues[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public int index0fy(double y)
    {
        int i;
        for (i = 0; i < count; i++) {
            if (yValues[i] == y) {
                return i;
            }
        }
        return -1;
    }
    protected int floorIndexOfX(double x)
    {
        int i;
        if (x < leftBound()) {
            return 0;
        }
        for (i = 0; i < count; i++) {
            if (xValues[i] > x) {
                return i - 1;
            }
        }
        return count;
    }

    protected double extrapolateLeft(double x)
    {
        if (count == 1) { return x; }
        return interpolate(x, xValues[0], xValues[1], yValues[0], yValues[1]);
    }
    protected double extrapolateRight(double x)
    {
        if (count == 1) { return x;}
        return interpolate(x, xValues[count - 2], xValues[count - 1], yValues[count - 2], yValues[count - 1]);
    }
    protected double interpolate(double x, int floorIndex)
    {
        if (count == 1) { return x; }
        return interpolate(x, xValues[floorIndex], xValues[floorIndex + 1], yValues[floorIndex], yValues[floorIndex + 1]);
    }
}