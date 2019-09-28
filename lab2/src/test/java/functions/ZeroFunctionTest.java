package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ZeroFunctionTest {
    ZeroFunction testFunction = new ZeroFunction();

    @Test
    public void testApplyConstant() {
        assertEquals(testFunction.apply(4), 0, 0.0001);
    }

    @Test
    public void testGetConstNumber() {
        assertEquals(testFunction.GetConstNumber(), 0, 0.0001);
    }
}
