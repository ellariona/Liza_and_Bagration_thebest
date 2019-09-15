package functions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LogFunctionTest {
    @Test
    public void testApplyLog()
    {
        LogFunction testFunction = new LogFunction();
        assertEquals(identityFunction.apply(10),  1, 0.01)
    }
}