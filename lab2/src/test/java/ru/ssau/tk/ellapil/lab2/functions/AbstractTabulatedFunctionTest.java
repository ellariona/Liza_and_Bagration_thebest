package ru.ssau.tk.ellapil.lab2.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AbstractTabulatedFunctionTest {
    double[] xValues = {0, 0.5, 1};
    double[] yValues = {0, 0.25, 1};
    double[] zValues = {1, 2, 3};
    ArrayTabulatedFunction arr = new ArrayTabulatedFunction(xValues, yValues);
    LinkedListTabulatedFunction link = new LinkedListTabulatedFunction(xValues, yValues);
    String sLink = "LinkedListTabulatedFunction size = 3\n[0.0; 0.0]\n[0.5; 0.25]\n[1.0; 1.0]";
    String sArr = "ArrayTabulatedFunction size = 3\n[0.0; 0.0]\n[0.5; 0.25]\n[1.0; 1.0]";
    ArrayTabulatedFunction testArr = new ArrayTabulatedFunction(xValues, zValues);
    String sTest = "ArrayTabulatedFunction size = 3\n[0.0; 1.0]\n[0.5; 2.0]\n[1.0; 3.0]";
    MockTabulatedFunction mockObj = new MockTabulatedFunction();

    @Test
    public void testTestToString() {
        assertEquals(sArr, arr.toString());
        assertEquals(sLink, link.toString());
        assertEquals(sTest, testArr.toString());
    }

    @Test
    public void testInterpolate() {
        assertEquals(mockObj.interpolate(2, mockObj.x0, mockObj.x1, mockObj.y0, mockObj.y1), mockObj.y0 + (mockObj.y1 - mockObj.y0) * (2 - mockObj.x0) / (mockObj.x1 - mockObj.x0), 0.001);
        assertEquals(mockObj.interpolate(mockObj.x0, mockObj.x0, mockObj.x1, mockObj.y0, mockObj.y1), mockObj.y0, 0.001);
        assertEquals(mockObj.interpolate(mockObj.x1, mockObj.x0, mockObj.x1, mockObj.y0, mockObj.y1), mockObj.y1, 0.001);
    }

    @Test
    public void testApply() {
        assertEquals(mockObj.apply(mockObj.x0), mockObj.y0, 0.0001);
        assertEquals(mockObj.apply(mockObj.x1), mockObj.y1, 0.0001);
        assertEquals(mockObj.apply(2.3), mockObj.interpolate(2.3, 0), 0.0001);
    }
}