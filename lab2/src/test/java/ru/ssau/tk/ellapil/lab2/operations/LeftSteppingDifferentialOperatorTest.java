package ru.ssau.tk.ellapil.lab2.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.ellapil.lab2.functions.ExpFunction;
import ru.ssau.tk.ellapil.lab2.functions.LogFunction;


import static org.testng.Assert.*;

public class LeftSteppingDifferentialOperatorTest {
    @Test
    public void testDerive() {
        double step = 3;
        SteppingDifferentialOperator differentialOperator = new LeftSteppingDifferentialOperator(step);
        assertEquals(differentialOperator.derive(new LogFunction()).apply(7), (Math.log10(7) - Math.log10(7 - step)) / step);
        assertEquals(differentialOperator.derive(new ExpFunction()).apply(5), (Math.exp(5) - Math.exp(5 - step)) / step);
    }
}