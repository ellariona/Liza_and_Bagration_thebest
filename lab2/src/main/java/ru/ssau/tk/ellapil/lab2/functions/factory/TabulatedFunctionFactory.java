package ru.ssau.tk.ellapil.lab2.functions.factory;

import ru.ssau.tk.ellapil.lab2.functions.*;

public interface TabulatedFunctionFactory {
    TabulatedFunction create(double[] xValues, double[] yValues);
}
