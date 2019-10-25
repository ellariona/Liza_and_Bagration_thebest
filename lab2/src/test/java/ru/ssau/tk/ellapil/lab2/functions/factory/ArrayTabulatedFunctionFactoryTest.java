package ru.ssau.tk.ellapil.lab2.functions.factory;

import org.testng.annotations.Test;
import ru.ssau.tk.ellapil.lab2.functions.ArrayTabulatedFunction;

import static org.testng.Assert.*;

public class ArrayTabulatedFunctionFactoryTest {

    @Test
    public void testCreate() {
        ArrayTabulatedFunctionFactory testClass = new ArrayTabulatedFunctionFactory();
        assertTrue(new ArrayTabulatedFunction(new double[]{2.3, 3.1}, new double[]{2.3, 3.1}).getClass() == (testClass.create(new double[]{2.3, 3.1}, new double[]{2.3, 3.1})).getClass());
    }
}