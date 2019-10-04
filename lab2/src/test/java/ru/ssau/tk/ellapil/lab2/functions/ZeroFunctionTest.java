package ru.ssau.tk.ellapil.lab2.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ZeroFunctionTest {
    ZeroFunction testFunction = new ZeroFunction();

    @Test
    public void testApplyConstant() {
        assertEquals(testFunction.apply(4), 0, 0.0001);
    }

    @Test
    public void testGetConstNumber() {
        assertEquals(testFunction.getConstNumber(), 0, 0.0001);
    }
}
