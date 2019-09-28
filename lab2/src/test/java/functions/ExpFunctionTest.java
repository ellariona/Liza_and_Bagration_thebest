package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpFunctionTest {

    @Test
    void applyExp() {
        ExpFunction expFunction = new ExpFunction();
        assertEquals(Math.exp(3), expFunction.apply(3));
        assertEquals(Math.exp(-2), expFunction.apply(-2));
        assertEquals(Math.exp(3.2), expFunction.apply((3.2)));
    }
}