package ru.ssau.tk.ellapil.lab2.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CompositeFunctionTest {
    double[] xValues = {1.2, 2, 3.3, 4};
    double[] yValues = {4, 5.2, 7.8, 9};
    IdentityFunction identityFunction = new IdentityFunction();
    CompositeFunction compositeFunction2 = new CompositeFunction(new SqrFunction().andThen(new LogFunction()), new ExpFunction());
    CompositeFunction compositeFunction1 = new CompositeFunction(new SqrFunction(), identityFunction);
    ArrayTabulatedFunction tabulatedFunction = new ArrayTabulatedFunction(xValues, yValues);
    ArrayTabulatedFunction tabulatedFunction1 = new ArrayTabulatedFunction(compositeFunction2, 1, 10, 10);
    LinkedListTabulatedFunction list = new LinkedListTabulatedFunction(xValues, yValues);

    @Test
    void applyTest() {
        double z1 = compositeFunction1.apply(3);
        assertEquals(9, z1, 0.01);
        z1 = compositeFunction2.apply(3);
        assertEquals(Math.exp(Math.log10(9)), z1, 0.01);
        assertEquals(9, new SqrFunction().andThen(tabulatedFunction).apply(2), 0.01);
        assertEquals(9 * 9, new SqrFunction().andThen(tabulatedFunction).andThen(compositeFunction1).apply(2), 0.00001);
        assertEquals(9 * 9, new SqrFunction().andThen(list).andThen(compositeFunction1).apply(2), 0.00001);
        assertEquals(Math.exp(4), tabulatedFunction1.andThen(new SqrFunction()).apply(10), 0.001);
    }
}