package ru.ssau.tk.ellapil.lab2.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AbstractTabulatedFunctionTest {
    double[] xValues={0,0.5,1};
    double[] yValues={0,0.25,1};
    ArrayTabulatedFunction arr=new ArrayTabulatedFunction(xValues,yValues);
    LinkedListTabulatedFunction link=new LinkedListTabulatedFunction(xValues,yValues);
    String sLink="LinkedListTabulatedFunction size = 3\n[0.0; 0.0]\n[0.5; 0.25]\n[1.0; 1.0]";
    String sArr="ArrayTabulatedFunction size = 3\n[0.0; 0.0]\n[0.5; 0.25]\n[1.0; 1.0]";
    @Test
    public void testTestToString() {
        assertEquals(sArr,arr.toString());
        assertEquals(sLink,link.toString());
    }
}