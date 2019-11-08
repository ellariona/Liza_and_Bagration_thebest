package ru.ssau.tk.ellapil.lab2.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.ellapil.lab2.functions.Point;
import ru.ssau.tk.ellapil.lab2.functions.TabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.ellapil.lab2.functions.factory.LinkedListTabulatedFunctionFactory;
import ru.ssau.tk.ellapil.lab2.functions.factory.TabulatedFunctionFactory;

import static org.testng.Assert.*;

public class TabulatedFunctionOperationServiceTest {

    double[] firstXValues = new double[]{2.1, 3, 5.4, 7};
    double[] firstYValues = new double[]{1, 2, 6, 23};
    double[] secondXValues = new double[]{1.1, 2.2, 3.3, 5};
    double[] secondYValues = new double[]{4.4, 5.5, 6.6, 6};

    @Test
    public void testAsPoints() {
        int i = 0;
        TabulatedFunction mass = (new ArrayTabulatedFunctionFactory()).create(firstXValues, firstYValues);
        Point[] points = TabulatedFunctionOperationService.asPoints((TabulatedFunction) mass);
        for (Point point : points) {
            assertEquals(point.x, mass.getX(i));
            assertEquals(point.y, mass.getY(i++));
        }
    }

    @Test
    public void testGetFactory() {
        TabulatedFunctionOperationService tabulatedFunctionOperationService = new TabulatedFunctionOperationService(new LinkedListTabulatedFunctionFactory());
        assertTrue(tabulatedFunctionOperationService.getFactory() instanceof LinkedListTabulatedFunctionFactory);
        tabulatedFunctionOperationService = new TabulatedFunctionOperationService(new ArrayTabulatedFunctionFactory());
        assertTrue(tabulatedFunctionOperationService.getFactory() instanceof ArrayTabulatedFunctionFactory);
    }

    @Test
    public void testSetFactory() {
        assertTrue(new TabulatedFunctionOperationService().getFactory() instanceof TabulatedFunctionFactory);
        TabulatedFunctionOperationService tabulatedFunctionOperationService = new TabulatedFunctionOperationService(new LinkedListTabulatedFunctionFactory());
        tabulatedFunctionOperationService.setFactory(new LinkedListTabulatedFunctionFactory());
        assertTrue(tabulatedFunctionOperationService.getFactory() instanceof LinkedListTabulatedFunctionFactory);
        tabulatedFunctionOperationService.setFactory(new ArrayTabulatedFunctionFactory());
        assertTrue(tabulatedFunctionOperationService.getFactory() instanceof ArrayTabulatedFunctionFactory);
    }

    @Test
    public void testSum() {
        TabulatedFunctionFactory arrayTest = new ArrayTabulatedFunctionFactory();
        TabulatedFunctionFactory listTest = new LinkedListTabulatedFunctionFactory();
        TabulatedFunctionOperationService tabulatedFunctionOperationService = new TabulatedFunctionOperationService(new LinkedListTabulatedFunctionFactory());
        TabulatedFunction a = arrayTest.create(firstXValues, firstYValues);
        TabulatedFunction b = arrayTest.create(firstXValues, secondYValues);
        TabulatedFunction c = tabulatedFunctionOperationService.sum(a, b);
        int i = 0;
        for (Point point : c) {
            assertEquals(point.x, firstXValues[i]);
            assertEquals(point.y, firstYValues[i] + secondYValues[i++]);
        }
        TabulatedFunction aNew = listTest.create(firstXValues, firstYValues);
        TabulatedFunction bNew = listTest.create(firstXValues, secondYValues);
        tabulatedFunctionOperationService = new TabulatedFunctionOperationService(new ArrayTabulatedFunctionFactory());
        TabulatedFunction cNew = tabulatedFunctionOperationService.sum(aNew, bNew);
        int j = 0;
        for (Point point : cNew) {
            assertEquals(point.x, firstXValues[j]);
            assertEquals(point.y, firstYValues[j] + secondYValues[j++]);
        }
    }

    @Test
    public void testSubtract() {
        TabulatedFunctionFactory arrayTest = new ArrayTabulatedFunctionFactory();
        TabulatedFunctionFactory listTest = new LinkedListTabulatedFunctionFactory();
        TabulatedFunctionOperationService tabulatedFunctionOperationService = new TabulatedFunctionOperationService(new LinkedListTabulatedFunctionFactory());
        TabulatedFunction a = arrayTest.create(firstXValues, firstYValues);
        TabulatedFunction b = arrayTest.create(firstXValues, secondYValues);
        TabulatedFunction c = tabulatedFunctionOperationService.subtract(a, b);
        int i = 0;
        for (Point point : c) {
            assertEquals(point.x, firstXValues[i]);
            assertEquals(point.y, firstYValues[i] - secondYValues[i++]);
        }
        TabulatedFunction aNew = listTest.create(firstXValues, firstYValues);
        TabulatedFunction bNew = listTest.create(firstXValues, secondYValues);
        tabulatedFunctionOperationService = new TabulatedFunctionOperationService(new ArrayTabulatedFunctionFactory());
        TabulatedFunction cNew = tabulatedFunctionOperationService.subtract(aNew, bNew);
        int j = 0;
        for (Point point : cNew) {
            assertEquals(point.x, firstXValues[j]);
            assertEquals(point.y, firstYValues[j] - secondYValues[j++]);
        }
    }

    @Test
    public void testMultiplication() {
        TabulatedFunctionFactory arrayTest = new ArrayTabulatedFunctionFactory();
        TabulatedFunctionFactory listTest = new LinkedListTabulatedFunctionFactory();
        TabulatedFunctionOperationService tabulatedFunctionOperationService = new TabulatedFunctionOperationService(new LinkedListTabulatedFunctionFactory());
        TabulatedFunction a = arrayTest.create(firstXValues, firstYValues);
        TabulatedFunction b = arrayTest.create(firstXValues, secondYValues);
        TabulatedFunction c = tabulatedFunctionOperationService.multiplication(a, b);
        int i = 0;
        for (Point point : c) {
            assertEquals(point.x, firstXValues[i]);
            assertEquals(point.y, firstYValues[i] * secondYValues[i++]);
        }
        TabulatedFunction aNew = listTest.create(firstXValues, firstYValues);
        TabulatedFunction bNew = listTest.create(firstXValues, secondYValues);
        tabulatedFunctionOperationService = new TabulatedFunctionOperationService(new ArrayTabulatedFunctionFactory());
        TabulatedFunction cNew = tabulatedFunctionOperationService.multiplication(aNew, bNew);
        int j = 0;
        for (Point point : cNew) {
            assertEquals(point.x, firstXValues[j]);
            assertEquals(point.y, firstYValues[j] * secondYValues[j++]);
        }
    }

    @Test
    public void testDivision() {
        TabulatedFunctionFactory arrayTest = new ArrayTabulatedFunctionFactory();
        TabulatedFunctionFactory listTest = new LinkedListTabulatedFunctionFactory();
        TabulatedFunctionOperationService tabulatedFunctionOperationService = new TabulatedFunctionOperationService(new LinkedListTabulatedFunctionFactory());
        TabulatedFunction a = arrayTest.create(firstXValues, firstYValues);
        TabulatedFunction b = arrayTest.create(firstXValues, secondYValues);
        TabulatedFunction c = tabulatedFunctionOperationService.division(a, b);
        int i = 0;
        for (Point point : c) {
            assertEquals(point.x, firstXValues[i]);
            assertEquals(point.y, firstYValues[i] / secondYValues[i++]);
        }
        TabulatedFunction aNew = listTest.create(firstXValues, firstYValues);
        TabulatedFunction bNew = listTest.create(firstXValues, secondYValues);
        tabulatedFunctionOperationService = new TabulatedFunctionOperationService(new ArrayTabulatedFunctionFactory());
        TabulatedFunction cNew = tabulatedFunctionOperationService.division(aNew, bNew);
        int j = 0;
        for (Point point : cNew) {
            assertEquals(point.x, firstXValues[j]);
            assertEquals(point.y, firstYValues[j] / secondYValues[j++]);
        }
    }
}