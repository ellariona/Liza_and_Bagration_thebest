package ru.ssau.tk.ellapil.lab2.operations;

import ru.ssau.tk.ellapil.lab2.concurrent.SynchronizedTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.*;
import ru.ssau.tk.ellapil.lab2.functions.factory.*;

public class TabulatedDifferentialOperator implements DifferentialOperator<TabulatedFunction> {
    TabulatedFunctionFactory factory;

    public TabulatedDifferentialOperator(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    public TabulatedDifferentialOperator() {
        this.factory = new ArrayTabulatedFunctionFactory();
    }

    public TabulatedFunctionFactory getFactory() {
        return factory;
    }

    public void setFactory(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    @Override
    public TabulatedFunction derive(TabulatedFunction function) {
        Point[] arrPoints = TabulatedFunctionOperationService.asPoints(function);
        double[] xValues = new double[arrPoints.length];
        double[] yValues = new double[arrPoints.length];
        for (int i = 0; i < xValues.length; i++) {
            xValues[i] = arrPoints[i].x;
        }
        for (int i = 0; i < xValues.length - 1; i++) {
            yValues[i] = (arrPoints[i + 1].y - arrPoints[i].y) / (xValues[i + 1] - xValues[i]);
        }
        yValues[xValues.length - 1] = yValues[xValues.length - 2];
        return factory.create(xValues, yValues);
    }

    public TabulatedFunction deriveSynchronously(TabulatedFunction function) {
        if (!(function instanceof SynchronizedTabulatedFunction)) {
            SynchronizedTabulatedFunction synchronizedTabulatedFunction = new SynchronizedTabulatedFunction(function);
            return synchronizedTabulatedFunction.doSynchronously(this::derive);
        }
        return ((SynchronizedTabulatedFunction) function).doSynchronously(this::derive);
    }
}

