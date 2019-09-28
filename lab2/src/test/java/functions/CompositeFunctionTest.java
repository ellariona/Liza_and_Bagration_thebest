package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompositeFunctionTest {
    double[] xValues = {1.2, 2, 3.3, 4};
    double[] yValues = {4, 5.2, 7.8, 9};
    IdentityFunction identityFunction = new IdentityFunction();
    SqrFunction sqrFunction = new SqrFunction();
    LogFunction logFunction = new LogFunction();
    ExpFunction expFunction = new ExpFunction();
    CompositeFunction compositeFunction2 = new CompositeFunction(sqrFunction.andThen(logFunction), expFunction);
    CompositeFunction compositeFunction1 = new CompositeFunction(sqrFunction, identityFunction);
    ArrayTabulatedFunction tabulatedFunction = new ArrayTabulatedFunction(xValues, yValues);
    ArrayTabulatedFunction tabulatedFunction1 = new ArrayTabulatedFunction(compositeFunction2, 1, 10, 10);
    LinkedListTabulatedFunction list = new LinkedListTabulatedFunction(xValues, yValues);
    @Test
    void applyTest() {
        double z1 = compositeFunction1.apply(3);
        assertEquals(9, z1);
        z1 = compositeFunction2.apply(3);
        assertEquals(Math.exp(Math.log10(9)), z1);
        assertEquals(9, sqrFunction.andThen(tabulatedFunction).apply(2));
        assertEquals(9 * 9, sqrFunction.andThen(tabulatedFunction).andThen(compositeFunction1).apply(2), 0.00001);
        assertEquals(9 * 9, sqrFunction.andThen(list).andThen(compositeFunction1).apply(2), 0.00001);
        assertEquals( Math.exp(4) ,tabulatedFunction1.andThen(sqrFunction).apply(10),0.001);
    }
}