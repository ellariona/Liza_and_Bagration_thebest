package ru.ssau.tk.ellapil.lab2.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

import ru.ssau.tk.ellapil.lab2.exceptions.ArrayIsNotSortedException;
import ru.ssau.tk.ellapil.lab2.exceptions.DifferentLengthOfArraysException;

public class ArrayTabulatedFunctionTest {
    private double[] xValues = {5, 6.7, 13};
    private double[] yValues = {7, 7.19, 15};
    private double[] zValues = {1, 2, 3, 4};
    private double[] bValues = {2, 1, 8};

    ArrayTabulatedFunction myFunc = new ArrayTabulatedFunction(xValues, yValues);
    ArrayTabulatedFunction myFunc2 = new ArrayTabulatedFunction(new SqrFunction(), 1, 6, 6);

    @Test
    void getCount() {
        assertEquals(3, myFunc.getCount(), 0.001);
    }

    @Test
    void getX() {
        assertEquals(1, myFunc2.getX(0), 0.001);
        assertEquals(5, myFunc.getX(0), 0.001);
        assertEquals(13, myFunc.getX(2), 0.001);
        assertEquals(6.7, myFunc.getX(1), 0.001);
    }

    @Test
    void getY() {
        assertEquals(7.19, myFunc.getY(1), 0.001);
        assertEquals(7, myFunc.getY(0), 0.001);
        assertEquals(15, myFunc.getY(2), 0.001);
    }

    @Test
    void leftBound() {
        assertEquals(5, myFunc.leftBound(), 0.001);
    }

    @Test
    void rightBound() {
        assertEquals(13, myFunc.rightBound(), 0.001);
    }

    @Test
    void indexOfX() {
        assertEquals(-1, myFunc.indexOfX(1), 0.001);
        assertEquals(-1, myFunc.indexOfX(0), 0.001);
        assertEquals(-1, myFunc.indexOfX(2), 0.001);
    }

    @Test
    void indexOfY() {
        assertEquals(-1, myFunc.indexOfY(1), 0.001);
        assertEquals(-1, myFunc.indexOfX(0), 0.001);
        assertEquals(-1, myFunc.indexOfX(2), 0.001);
    }

    @Test
    void floorIndexOfX() {
        assertEquals(1, myFunc.floorIndexOfX(6.7), 0.001);
        assertEquals(0, myFunc.floorIndexOfX(5), 0.001);
    }

    @Test
    void extrapolateLeft() {
        assertEquals(7.19, myFunc.extrapolateLeft(6.7), 0.001);
        assertEquals(7, myFunc.extrapolateLeft(5), 0.001);
    }

    @Test
    void extrapolateRight() {
        assertEquals(7.19, myFunc.extrapolateRight((6.7)), 0.001);
        assertEquals(15, myFunc.extrapolateRight(13), 0.001);
    }

    @Test
    void interpolate() {
        assertEquals(7, myFunc.interpolate(5, 0), 0.001);
        assertEquals(7.19, myFunc.interpolate(6.7, 1), 0.001);
    }

    @Test
    void setY() {
        myFunc.setY(0, 7);
        assertEquals(7, myFunc.getY(0), 0.001);
        myFunc.setY(1, 7.19);
        assertEquals(7.19, myFunc.getY(1), 0.001);
        myFunc.setY(2, 15);
        assertEquals(15, myFunc.getY(2), 0.001);
    }

    @Test
    void testArrayTabulated() {
        assertThrows(DifferentLengthOfArraysException.class, () -> {
            ArrayTabulatedFunction testValue = new ArrayTabulatedFunction(xValues, zValues);
        });
        assertThrows(ArrayIsNotSortedException.class, () -> {
            ArrayTabulatedFunction secondValue = new ArrayTabulatedFunction(bValues, yValues);
        });
    }

    @Test
    public void testInsert() {
        myFunc.insert(5,10);
        assertEquals(myFunc.getY(0),10,0.0001);
        myFunc.insert(6,10);
        assertEquals(myFunc.getY(1),10,0.0001);
        assertEquals(myFunc.getY(2),7.19,0.0001);
    }
}


