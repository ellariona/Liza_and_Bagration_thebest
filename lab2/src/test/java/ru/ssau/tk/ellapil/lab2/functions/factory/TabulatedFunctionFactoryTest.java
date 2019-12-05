package ru.ssau.tk.ellapil.lab2.functions.factory;

import org.testng.annotations.Test;
import ru.ssau.tk.ellapil.lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.StrictTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.TabulatedFunction;

import static org.testng.Assert.*;

public class TabulatedFunctionFactoryTest {
    double[] xValues = new double[]{1, 2, 3};
    double[] yValues = new double[]{1, 2, 3};

    @Test
    public void testCreate() {
        ArrayTabulatedFunctionFactory arr = new ArrayTabulatedFunctionFactory();
        LinkedListTabulatedFunctionFactory list = new LinkedListTabulatedFunctionFactory();
        TabulatedFunction isList = list.create(xValues, yValues);
        TabulatedFunction isArr = arr.create(xValues, yValues);
        assertTrue(isList instanceof LinkedListTabulatedFunction);
        assertTrue(isArr instanceof ArrayTabulatedFunction);
    }

    @Test
    public void testCreateStrict() {
        ArrayTabulatedFunctionFactory arr = new ArrayTabulatedFunctionFactory();
        TabulatedFunction function = arr.createStrict(xValues, yValues);
        assertTrue(function instanceof StrictTabulatedFunction);
        assertEquals(function.apply(xValues[0]), yValues[0], 0.0001);
        assertEquals(function.apply(xValues[1]), yValues[1], 0.0001);
        assertThrows(UnsupportedOperationException.class, () -> {
            function.apply(5);
        });
    }
}