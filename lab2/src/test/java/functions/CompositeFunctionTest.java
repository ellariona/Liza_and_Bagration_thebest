package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompositeFunctionTest {

    IdentityFunction identityFunction = new IdentityFunction();
    SqrFunction sqrFunction = new SqrFunction();
    LogFunction logFunction = new LogFunction();
    ExpFunction expFunction = new ExpFunction();
    CompositeFunction compositeFunction2 = new CompositeFunction(sqrFunction.andThen(logFunction), expFunction);
    CompositeFunction compositeFunction1 = new CompositeFunction(sqrFunction, identityFunction);

    @Test
    void applyTest() {
        double z1 = compositeFunction1.apply(3);
        assertEquals(9, z1);
        z1 = compositeFunction2.apply(3);
        assertEquals(Math.exp(Math.log10(9)), z1);
    }
}