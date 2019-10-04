package ru.ssau.tk.ellapil.lab2.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ExpFunctionTest {

    @Test
    void applyExp() {
        ExpFunction expFunction = new ExpFunction();
        assertEquals(Math.exp(3), expFunction.apply(3));
        assertEquals(Math.exp(-2), expFunction.apply(-2));
        assertEquals(Math.exp(3.2), expFunction.apply((3.2)));
    }
}