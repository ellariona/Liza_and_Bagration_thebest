package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqrFunctionTest {
    @Test
public void testApplySqr()
    {
        SqrFunction testFunction = new SqrFunction();
        assertEquals(identityFunction.apply(9),  81, 0.01)
    }
}

