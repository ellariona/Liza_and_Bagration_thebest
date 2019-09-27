package functions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AbstractTabulatedFunction
{
    private MockTabulatedFunction mockobjec = new MockTabulatedFunction();
    @Test
    public void testInterpolate()
    {
        assertEquals(mockobjec.interpolate(-2, 7, 8, 9, 10), 5, 0.0001);
        assertEquals(mockobjec.interpolate(0, 7, 8, 9, 10), 5, 0.0001);
        assertEquals(mockobjec.interpolate(2, 7, 8, 9, 10), 5, 0.0001);
    }
    @Test
    public void testApplay()
    {
        assertEquals(mockobjec.apply(-2), 8.48, 0.0001);
        assertEquals(mockobjec.apply(0), 8.48, 0.0001);
        assertEquals(mockobjec.apply(2), 8.48, 0.0001);
    }
}
