package ru.ssau.tk.ellapil.lab2.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.ellapil.lab2.functions.LogFunction;


import static org.testng.Assert.*;

public class LeftSteppingDifferentialOperatorTest {
private double step = 3;
    @Test
    public void testDerive() {
        SteppingDifferentialOperator differentialOperator = new LeftSteppingDifferentialOperator(step);
        assertEquals((Math.log(7) - Math.log(7 - step))/step, differentialOperator.derive(new LogFunction()));
    }
}