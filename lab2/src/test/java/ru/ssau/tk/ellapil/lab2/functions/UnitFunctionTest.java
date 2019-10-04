package ru.ssau.tk.ellapil.lab2.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UnitFunctionTest {
    UnitFunction testFunction = new UnitFunction();

    @Test
    public void testApplyConstant() {
        assertEquals(testFunction.apply(4), 1, 0.0001);
    }

    @Test
    public void testGetConstNumber() {
        assertEquals(testFunction.getConstNumber(), 1, 0.0001);
    }
}


