package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpFunctionTest {

    @Test
    void applyExp() {
        ExpFunction expFunction = new ExpFunction();
        assertEquals(Math.exp(3), expFunction.apply(3));
    }
}