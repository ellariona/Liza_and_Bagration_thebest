package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompositeFunctionTest {

    IdentityFunction identityFunction = new IdentityFunction();
    SqrFunction sqrFunction = new SqrFunction();
    CompositeFunction compositeFunction1 = new CompositeFunction(sqrFunction, identityFunction);
    CompositeFunction compositeFunction2 = new CompositeFunction(compositeFunction1, identityFunction);
    @Test
    void applyTest() {
        double z1 = compositeFunction1.apply(3);
        assertEquals(9, z1);
        z1=compositeFunction1.apply(3);
        assertEquals(9, z1);
    }
}