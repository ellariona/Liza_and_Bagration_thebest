package ru.ssau.tk.ellapil.lab2.functions;

import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.testng.Assert.*;

public class LinkedListTabulatedFunctionTest {
    double[] x = {1.2, 2.5, 3.3, 4.8, 9.5};
    double[] y = {4, 8, 12, 15, 18};
    LinkedListTabulatedFunction listOne = new LinkedListTabulatedFunction(x, y);
    LinkedListTabulatedFunction listTwo = new LinkedListTabulatedFunction(new SqrFunction(), 1, 3, 3);

    @Test
    void getCount() {
        assertEquals(5, listOne.getCount());
    }

    @Test
    void leftBound() {
        assertEquals(1.2, listOne.leftBound());
    }

    @Test
    void rightBound() {
        assertEquals(9.5, listOne.rightBound());
    }

    @Test
    void getX() {
        assertEquals(1.2, listOne.getX(0), 0.01);
        assertEquals(2, listTwo.getX(1), 0.01);
        assertEquals(3.3, listOne.getX(2), 0.01);
    }

    @Test
    void getY() {
        assertEquals(4, listOne.getY(0), 0.01);
        assertEquals(4, listTwo.getY(1), 0.01);
        assertEquals(15, listOne.getY(3), 0.01);
    }

    @Test
    void setY() {
        listOne.setY(1, 10);
        assertEquals(10, listOne.getY(1), 0.01);
    }

    @Test
    void indexOfX() {
        assertEquals(1, listTwo.indexOfX(2));
        assertEquals(2, listOne.indexOfX(3.3));
        assertEquals(3, listOne.indexOfX(4.8));
        assertEquals(-1, listOne.indexOfX(4.5));
    }

    @Test
    void indexOfY() {
        assertEquals(2, listTwo.indexOfY(9));
        assertEquals(1, listOne.indexOfY(8));
        assertEquals(2, listOne.indexOfY(12));
        assertEquals(-1, listOne.indexOfY(4.5));
    }

    @Test
    void floorIndexOfX() {
        assertThrows(IllegalArgumentException.class, () -> {
            listOne.floorIndexOfX(-1.2);
        });
        assertEquals(1, listTwo.floorIndexOfX(2.2));
        assertEquals(2, listOne.floorIndexOfX(4.5));
        assertEquals(1, listOne.floorIndexOfX(3));
    }

    @Test
    void interpolate() {
        assertThrows(IllegalArgumentException.class, () -> {
            LinkedListTabulatedFunction listThree = new LinkedListTabulatedFunction(new double[]{12}, new double[]{13});
        });

        assertEquals(8 + (12 - 8) / (3.3 - 2.5) * (3 - 2.5), listOne.interpolate(3, 1));
    }

    @Test
    void extrapolateRight() {
        assertEquals(15 + (18 - 15) / (9.5 - 4.8) * (9 - 4.8), listOne.extrapolateRight(9));
    }

    @Test
    void extrapolateLeft() {
        assertEquals(4 + (8 - 4) / (2.5 - 1.2) * (1.3 - 1.2), listOne.extrapolateLeft(1.3));
    }

    @Test
    void iterator() {
        Iterator<Point> iterator = listOne.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Point point = iterator.next();
            assertEquals(listOne.getX(i++), point.x, 0.0001);
        }
        Iterator<Point> finalIterator = iterator;
        assertThrows(NoSuchElementException.class, () -> {
            Point point = finalIterator.next();
        });
        i = 0;
        for (Point point : listOne) {
            assertEquals(listOne.getX(i++), point.x, 0.0001);
        }
        iterator = listTwo.iterator();
        i = 0;
        while (iterator.hasNext()) {
            Point point = iterator.next();
            assertEquals(listTwo.getX(i++), point.x, 0.0001);
        }
        i = 0;
        for (Point point : listTwo) {
            assertEquals(listTwo.getX(i++), point.x, 0.0001);
        }
    }

    @Test
    public void testApply() {
        assertEquals(listOne.apply(1.2), 4, 0.0001);
        assertEquals(listOne.apply(1.5), listOne.interpolate(1.5, 0), 0.0001);
    }

    @Test
    public void testRemove() {
        listOne.remove(2);
        assertEquals(listOne.getX(2), 4.8);
    }
}