package ru.ssau.tk.ellapil.lab2.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.ellapil.lab2.functions.ExpFunction;
import ru.ssau.tk.ellapil.lab2.functions.LogFunction;

import static org.testng.Assert.*;

public class RightSteppingDifferentialOperatorTest {

    @Test
    public void testDerive() {
        double step = 3;
        SteppingDifferentialOperator differentialOperator = new RightSteppingDifferentialOperator(step);
        assertEquals(differentialOperator.derive(new LogFunction()).apply(7), (Math.log10(7 + step) - Math.log10(7)) / step);
        assertEquals(differentialOperator.derive(new ExpFunction()).apply(5), (Math.exp(5 + step) - Math.exp(5)) / step);
    }
}