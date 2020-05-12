package at.fhj.msd.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *  Testing class for BlackoutException
 *
 * @author Michael Lamprecht
 * @version %I%, %G%
 * @since 1.1
 */
@DisplayName("Testing BlackoutException implementation")
public class BlackoutExceptionTest {
    private BlackoutException blackoutCustom, blackoutDefault;

    /**
     * inits a custom and a default BlackoutException EACH test
     */
    @BeforeEach
    void setup() {
        // SETUP PHASE
        blackoutCustom = new BlackoutException("My custom message.");
        blackoutDefault = new BlackoutException();
    }

    /**
     * Test for constructor of BlackoutException with a custom error message
     */
    @Test
    @DisplayName("Testing constructor custom")
    public void testConstructorCustom(){
        assertEquals("My custom message.", blackoutCustom.getMessage());
    }

    /**
     * Test for constructor of BlackoutException with the default error message
     */
    @Test
    @DisplayName("Testing constructor default")
    public void testConstructorDefault(){
        assertEquals(BlackoutException.ERROR_MESSAGE, blackoutDefault.getMessage());
    }
}
