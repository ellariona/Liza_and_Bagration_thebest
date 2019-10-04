package ru.ssau.tk.ellapil.lab2.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IdentityFunctionTest {

    @Test
    public void testApply() {
        IdentityFunction identityFunction = new IdentityFunction();
        for (int j = 0; j < 9; j++) {
            double z = identityFunction.apply(j);
            assertEquals(z, j, 0.01);
        }
    }
}