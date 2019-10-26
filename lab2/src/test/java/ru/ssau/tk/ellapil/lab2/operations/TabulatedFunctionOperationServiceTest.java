package ru.ssau.tk.ellapil.lab2.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.ellapil.lab2.functions.Point;
import ru.ssau.tk.ellapil.lab2.functions.TabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.factory.ArrayTabulatedFunctionFactory;

import static org.testng.Assert.*;

public class TabulatedFunctionOperationServiceTest {

    double[] firstXValues = new double[]{7, 5.4, 2.1, 3};
    double[] firstYValues = new double[]{52, 1, 6, 7.1};
    double[] secondXValues = new double[]{1.1, 2.2, 3.3};
    double[] secondYValues = new double[]{4.4, 5.5, 6.6};
    double[] thirdXValues = new double[]{1, 2, 3, 4};
    double[] thirdYValues = new double[]{5, 6, 7, 18};

    TabulatedFunctionOperationService testClass = new TabulatedFunctionOperationService();

    @Test
    public void testAsPoints() {
        int i = 0;
       // for ()
        {}
    }

    @Test
    public void testGetFactory() {
    }

    @Test
    public void testSetFactory() {
    }

    @Test
    public void testSum() {
    }

    @Test
    public void testSubtract() {
    }
}