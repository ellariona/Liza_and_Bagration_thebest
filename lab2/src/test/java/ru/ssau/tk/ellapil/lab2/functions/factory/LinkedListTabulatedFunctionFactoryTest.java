package ru.ssau.tk.ellapil.lab2.functions.factory;

import org.testng.annotations.Test;
import ru.ssau.tk.ellapil.lab2.functions.LinkedListTabulatedFunction;

import static org.testng.Assert.*;

public class LinkedListTabulatedFunctionFactoryTest {

    @Test
    public void testCreate() {
        LinkedListTabulatedFunctionFactory testClass = new LinkedListTabulatedFunctionFactory();
        assertTrue(new LinkedListTabulatedFunction(new double[]{2.3, 3.1}, new double[]{2.3, 3.1}).getClass() == (testClass.create(new double[]{2.3, 3.1}, new double[]{2.3, 3.1})).getClass());
    }
}