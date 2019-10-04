package ru.ssau.tk.ellapil.lab2.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ConstantFunctionTest {
    ConstantFunction testFunction = new ConstantFunction(2);

    @Test
    public void testApplyConstant() {
        assertEquals(testFunction.apply(4), 2, 0.0001);
    }

    @Test
    public void testGetConstNumber() {
        assertEquals(testFunction.getConstNumber(), 2, 0.0001);
    }
}
