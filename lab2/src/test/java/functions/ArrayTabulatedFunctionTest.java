package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTabulatedFunctionTest {
    private double[] Xvalues = {5, 6.7, 13};
    private double[] Yvavlues = {7, 7.19, 15};

    ArrayTabulatedFunction myFunc = new ArrayTabulatedFunction(Xvalues, Yvavlues);

    @Test
    void getCount() {
        assertEquals(3, myFunc.getCount(), 0.001);
    }

    @Test
    void getX() {
        assertEquals(6.7, myFunc.getX(1), 0.001);
    }

    @Test
    void getY() {
        assertEquals(7.19, myFunc.getY(1), 0.001);
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
    }

    @Test
    void indexOfY() {
        assertEquals(-1, myFunc.indexOfY(1), 0.001);
    }

    @Test
    void floorIndexOfX() {
        assertEquals(1, myFunc.floorIndexOfX(6.7), 0.001);
    }

    @Test
    void extrapolateLeft() {
        assertEquals(7.19, myFunc.extrapolateLeft(6.7), 0.001);
    }

    @Test
    void extrapolateRight() {
        assertEquals(7.19, myFunc.extrapolateRight((6.7)), 0.001);
    }

    @Test
    void interpolate() {
        assertEquals(7, myFunc.interpolate(5, 0), 0.001);
    }

    @Test
    void setY() {
        myFunc.setY(1,2);
        assertEquals(2, myFunc.getY(1), 0.001);
    }
}