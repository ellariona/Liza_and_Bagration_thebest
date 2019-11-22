package ru.ssau.tk.ellapil.lab2.concurrent;

import org.testng.annotations.Test;
import ru.ssau.tk.ellapil.lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.ellapil.lab2.functions.SqrFunction;

import static org.testng.Assert.*;

public class SynchronizedTabulatedFunctionTest {
    LinkedListTabulatedFunction list = new LinkedListTabulatedFunction(new double[]{1.2, 2.5, 3.3, 4.8, 9.5}, new double[]{4, 8, 12, 15, 18});
    ArrayTabulatedFunction array = new ArrayTabulatedFunction(new SqrFunction(), 1, 6, 6);
    SynchronizedTabulatedFunction syncList = new SynchronizedTabulatedFunction(list);
    SynchronizedTabulatedFunction syncArray = new SynchronizedTabulatedFunction(array);

    @Test
    public void testGetCount() {
        assertEquals(syncArray.getCount(), 6, 0.001);
        assertEquals(syncList.getCount(), 5, 0.001);
    }

    @Test
    public void testGetX() {
        assertEquals(syncArray.getX(1), 2, 0.001);
        assertEquals(syncList.getX(1), 2.5, 0.001);
    }

    @Test
    public void testGetY() {
        assertEquals(syncArray.getY(1), 4, 0.001);
        assertEquals(syncList.getY(1), 8, 0.001);
    }

    @Test
    public void testSetY() {
        syncArray.setY(1, 5);
        assertEquals(syncArray.getY(1), 5, 0.001);
        syncList.setY(1, 5);
        assertEquals(syncList.getY(1), 5, 0.001);
    }

    @Test
    public void testIndexOfX() {
        assertEquals(syncArray.indexOfX(2), 1, 0.001);
        assertEquals(syncList.indexOfX(1.2), 0, 0.001);
    }

    @Test
    public void testIndexOfY() {
        assertEquals(syncArray.indexOfY(9), 2, 0.001);
        assertEquals(syncList.indexOfY(8), 1, 0.001);
    }

    @Test
    public void testLeftBound() {
        assertEquals(syncArray.leftBound(), 1, 0.001);
        assertEquals(syncList.leftBound(), 1.2, 0.001);
    }

    @Test
    public void testRightBound() {
        assertEquals(syncArray.rightBound(), 6, 0.001);
        assertEquals(syncList.rightBound(), 9.5, 0.001);
    }

    @Test
    public void testIterator() {
    }

    @Test
    public void testApply() {
        assertEquals(syncArray.apply(2), 4, 0.001);
        assertEquals(syncList.apply(2.5), 8, 0.001);
    }
}