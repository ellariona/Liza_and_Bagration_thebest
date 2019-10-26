package ru.ssau.tk.ellapil.lab2.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.ellapil.lab2.functions.LogFunction;


import static org.testng.Assert.*;

public class LeftSteppingDifferentialOperatorTest {
    @Test
    public void testDerive() {
        double step = 3;
        SteppingDifferentialOperator differentialOperator = new LeftSteppingDifferentialOperator(step);
        assertEquals((Math.log(7) - Math.log(7 - step))/ step, differentialOperator.derive(new LogFunction()).apply(7));
    }
}