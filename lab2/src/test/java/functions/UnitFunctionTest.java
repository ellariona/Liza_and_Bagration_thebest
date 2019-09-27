package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnitFunctionTest
{
    UnitFunction testFunction = new UnitFunction();
    @Test
    public void testApplyConstant()
    {
        assertEquals(testFunction.apply(4), 1, 0.0001);
    }
    @Test
    public void testGetConstNumber()
    {
        assertEquals(testFunction.GetConstNumber(), 1, 0.0001);
    }
}


