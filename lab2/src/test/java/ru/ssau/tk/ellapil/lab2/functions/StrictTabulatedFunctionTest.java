package ru.ssau.tk.ellapil.lab2.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StrictTabulatedFunctionTest {
    double[] x = {1.2, 2.5, 3.3, 4.8, 9.5};
    double[] y = {4, 8, 12, 15, 18};
    LinkedListTabulatedFunction list = new LinkedListTabulatedFunction(x, y);
    ArrayTabulatedFunction array = new ArrayTabulatedFunction(new SqrFunction(), 1, 6, 6);
    StrictTabulatedFunction strictArray = new StrictTabulatedFunction(array);
    StrictTabulatedFunction strictList = new StrictTabulatedFunction(list);

    @Test
    public void testGetCount() {
        assertEquals(strictArray.getCount(), array.getCount(), 0.0001);
        assertEquals(strictList.getCount(), list.getCount(), 0.0001);
    }

    @Test
    public void testGetX() {
        assertEquals(strictArray.getX(1), array.getX(1), 0.0001);
        assertEquals(strictList.getX(2), list.getX(2), 0.0001);
    }

    @Test
    public void testGetY() {
        assertEquals(strictArray.getY(1), array.getY(1), 0.0001);
        assertEquals(strictList.getY(2), list.getY(2), 0.0001);
    }

    @Test
    public void testSetY() {
        strictArray.setY(0, 2);
        assertEquals(strictArray.getY(0), array.getY(0), 0.0001);
        assertEquals(strictArray.getY(0), 2, 0.0001);
        strictList.setY(1, 10);
        assertEquals(strictList.getY(1), list.getY(1), 0.0001);
    }

    @Test
    public void testIndexOfX() {
        assertEquals(strictArray.indexOfX(1), array.indexOfX(1), 0.0001);
        assertEquals(strictArray.indexOfX(4), array.indexOfX(4), 0.0001);
        assertEquals(strictList.indexOfX(1.2), list.indexOfX(1.2), 0.0001);
        assertEquals(strictList.indexOfX(4.8), list.indexOfX(4.8), 0.0001);
        assertEquals(strictList.indexOfX(2), list.indexOfX(2), 0.0001);
    }

    @Test
    public void testIndexOfY() {
        assertEquals(strictArray.indexOfY(1), array.indexOfY(1), 0.0001);
        assertEquals(strictArray.indexOfY(4), array.indexOfY(4), 0.0001);
        assertEquals(strictList.indexOfY(4), list.indexOfY(4), 0.0001);
        assertEquals(strictList.indexOfY(12), list.indexOfY(12), 0.0001);
        assertEquals(strictList.indexOfY(200), list.indexOfY(200), 0.0001);
    }

    @Test
    public void testLeftBound() {
        assertEquals(strictArray.leftBound(), array.leftBound(), 0.0001);
        assertEquals(strictList.leftBound(), list.leftBound(), 0.0001);
    }

    @Test
    public void testRightBound() {
        assertEquals(strictArray.rightBound(), array.rightBound(), 0.0001);
        assertEquals(strictList.rightBound(), list.rightBound(), 0.0001);
    }

    @Test
    public void testIterator() {
        assertEquals(strictArray.iterator(), array.iterator());
        assertEquals(strictList.iterator(), list.iterator());
    }

    @Test
    public void testApply() {
        assertThrows(UnsupportedOperationException.class, () -> {
            strictArray.apply(10);
        });
        assertEquals(strictArray.apply(2), 4, 0.0001);
        assertThrows(UnsupportedOperationException.class, () -> {
            strictList.apply(1);
        });
        assertEquals(strictList.apply(1.2), 4, 0.0001);
    }
}