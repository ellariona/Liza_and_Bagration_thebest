package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTabulatedFunctionTest {
    double[] x = {1.2, 2.5, 3.3, 4.8, 9.5};
    double[] y = {4, 8, 12, 15, 18};
    LinkedListTabulatedFunction listOne = new LinkedListTabulatedFunction(x, y);
    SqrFunction func = new SqrFunction();
    LinkedListTabulatedFunction listTwo = new LinkedListTabulatedFunction(func, 1, 3, 3);

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
        assertEquals(1.2, listOne.getX(0));
        assertEquals(2,listTwo.getX(1));
        assertEquals(3.3, listOne.getX(2));
    }

    @Test
    void getY() {
        assertEquals(4, listOne.getY(0));
        assertEquals(4, listTwo.getY(1));
        assertEquals(15,listOne.getY(3));
    }

    @Test
    void setY() {
        listOne.setY(1, 10);
        assertEquals(10, listOne.getY(1));
    }

    @Test
    void indexOfX() {
        assertEquals(1, listTwo.indexOfX(2));
        assertEquals(2, listOne.indexOfX(3.3));
        assertEquals(3, listOne.indexOfX(4.8));
    }

    @Test
    void indexOfY() {
        assertEquals(2, listTwo.indexOfY(9));
        assertEquals(1, listOne.indexOfY(8));
        assertEquals(2, listOne.indexOfY(12));
    }

    @Test
    void floorIndexOfX() {
        assertEquals(1, listTwo.floorIndexOfX(2.2));
        assertEquals(2, listOne.floorIndexOfX(4.5));
        assertEquals(1, listOne.floorIndexOfX(3));
    }

    @Test
    void interpolate() {
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
}