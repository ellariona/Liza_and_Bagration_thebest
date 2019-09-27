package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConstantFunctionTest
{
    ConstantFunction testFunction = new ConstantFunction(2);
    @Test
    public void testApplyConstant()
    {
        assertEquals(testFunction.apply(4), 2, 0.0001);
    }
    @Test
    public void testGetConstNumber()
    {
        assertEquals(testFunction.GetConstNumber(), 2, 0.0001);
    }
}
