package ru.ssau.tk.ellapil.lab2.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.ellapil.lab2.functions.ExpFunction;
import ru.ssau.tk.ellapil.lab2.functions.LogFunction;

import static org.testng.Assert.*;

public class MiddleSteppingDifferentialOperatorTest {

    @Test
    public void testDerive() {
        double step = 3;
        SteppingDifferentialOperator differentialOperator = new MiddleSteppingDifferentialOperator(step);
        assertEquals(differentialOperator.derive(new LogFunction()).apply(7), (Math.log10(7 + step) - Math.log10(7 - step)) / (2*step));
        assertEquals(differentialOperator.derive(new ExpFunction()).apply(5), (Math.exp(5 + step) - Math.exp(5 - step)) / (2*step));
    }
}