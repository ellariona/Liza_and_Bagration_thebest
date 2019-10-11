package ru.ssau.tk.ellapil.lab2.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class
LogFunctionTest {
    @Test
    public void testApplyLog() {
        LogFunction testFunctionLog = new LogFunction();
        assertEquals(Math.log10(-3), testFunctionLog.apply(-3), 0.001);
        assertEquals(Math.log10(7), testFunctionLog.apply(7), 0.001);
        assertEquals(Math.log10(2.5), testFunctionLog.apply(2.5), 0.001);
    }
}