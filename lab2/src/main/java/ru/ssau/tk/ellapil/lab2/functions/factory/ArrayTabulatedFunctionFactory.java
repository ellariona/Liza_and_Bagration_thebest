package ru.ssau.tk.ellapil.lab2.functions.factory;

import ru.ssau.tk.ellapil.lab2.functions.ArrayTabulatedFunction;

public class ArrayTabulatedFunctionFactory implements TabulatedFunctionFactory {
    @Override
    public ArrayTabulatedFunction create(double[] xValues, double[] yValues) {
        return new ArrayTabulatedFunction(xValues, yValues);
    }
}
