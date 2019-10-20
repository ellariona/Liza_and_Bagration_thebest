package ru.ssau.tk.ellapil.lab2.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UnmodifiableTabulatedFunctionTest {
    UnmodifiableTabulatedFunction wrapper = new UnmodifiableTabulatedFunction(new LinkedListTabulatedFunction(new double[]{2., 6.2, 8.3, 12.4}, new double[]{1., 3.7, 5.4, 7. }));
    @Test
    public void testGetCount() {
        assertEquals(wrapper.getCount(), 4);
    }

    @Test
    public void testGetX() {
        assertEquals(wrapper.getX(0), 2.);
        assertEquals(wrapper.getX(1), 6.2);
        assertEquals(wrapper.getX(3), 12.4);
    }

    @Test
    public void testGetY() {
        assertEquals(wrapper.getY(0), 1.);
        assertEquals(wrapper.getY(1), 3.7);
        assertEquals(wrapper.getY(3), 7.);
    }

    @Test
    public void testSetY() {
        assertThrows(UnsupportedOperationException.class, () -> wrapper.setY(0, 1.));
    }

    @Test
    public void testIndexOfX() {
        assertEquals(wrapper.indexOfX(2.),0);
        assertEquals(wrapper.indexOfX(6.2), 1);
        assertEquals(wrapper.indexOfX(8.3), 2);
    }

    @Test
    public void testIndexOfY() {
        assertEquals(wrapper.indexOfY(1.), 0);
        assertEquals(wrapper.indexOfY(3.7),1);
        assertEquals(wrapper.indexOfY(5.4), 2);
    }

    @Test
    public void testLeftBound() {
        assertEquals(wrapper.leftBound(), 2.);
    }

    @Test
    public void testRightBound() {
        assertEquals(wrapper.rightBound(), 12.4);
    }

    @Test
    public void testIterator() {
        assertEquals(wrapper.iterator().next().x, 2.);
    }

    @Test
    public void testApply() {
        assertEquals(wrapper.apply(2.), 1.);
        assertEquals(wrapper.apply(6.2), 3.7);
    }
}