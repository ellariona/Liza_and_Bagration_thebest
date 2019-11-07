package ru.ssau.tk.ellapil.lab2.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.ellapil.lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.ellapil.lab2.functions.factory.LinkedListTabulatedFunctionFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TabulatedDifferentialOperatorTest {
    TabulatedDifferentialOperator array = new TabulatedDifferentialOperator(new ArrayTabulatedFunctionFactory());
    TabulatedDifferentialOperator isArray = new TabulatedDifferentialOperator();
    TabulatedDifferentialOperator linkedList = new TabulatedDifferentialOperator(new LinkedListTabulatedFunctionFactory());
    double[] xValues = {5, 6.7, 13};
    double[] yValues = {7, 7.19, 15};
    ArrayTabulatedFunction myFunc = new ArrayTabulatedFunction(xValues, yValues);

    @Test
    public void testDerive() {
        var diffArray = array.derive(myFunc);
        assertEquals(diffArray.getY(0), (7.19 - 7) / (6.7 - 5), 0.0001);
        assertEquals(diffArray.getY(1), (15 - 7.19) / (13 - 6.7), 0.0001);
        assertEquals(diffArray.getY(2), (15 - 7.19) / (13 - 6.7), 0.0001);
    }

    @Test
    public void testGetFactory() {
        assertTrue(isArray.getFactory() instanceof ArrayTabulatedFunctionFactory);
        assertTrue(linkedList.getFactory() instanceof LinkedListTabulatedFunctionFactory);
    }

    @Test
    public void testSetFactory() {
        isArray.setFactory(new LinkedListTabulatedFunctionFactory());
        assertTrue(isArray.getFactory() instanceof LinkedListTabulatedFunctionFactory);
    }
}