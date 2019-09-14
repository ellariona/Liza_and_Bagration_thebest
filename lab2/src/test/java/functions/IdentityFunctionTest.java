package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdentityFunctionTest {

    @Test
    public void testApply() {
        IdentityFunction identityFunction = new IdentityFunction();
        for (int j = 0; j < 9; j++) {
            double z = identityFunction.apply(j);
            assertEquals(z, j);
        }
    }
}