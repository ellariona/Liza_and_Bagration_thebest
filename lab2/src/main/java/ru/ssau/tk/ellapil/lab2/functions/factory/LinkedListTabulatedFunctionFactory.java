package ru.ssau.tk.ellapil.lab2.functions.factory;

import ru.ssau.tk.ellapil.lab2.functions.*;

public class LinkedListTabulatedFunctionFactory implements TabulatedFunctionFactory {
    @Override
    public LinkedListTabulatedFunction create(double[] xValues, double[] yValues) {
        return new LinkedListTabulatedFunction(xValues, yValues);
    }

}
