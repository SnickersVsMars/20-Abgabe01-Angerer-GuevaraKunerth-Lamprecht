package at.fhj.msd.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    @DisplayName("Testing constructor custom")
    public void testConstructorCustom(){
        assertEquals("My custom message.", blackoutCustom.getMessage());
    }

    @Test
    @DisplayName("Testing constructor default")
    public void testConstructorDefault(){
        assertEquals(BlackoutException.ERROR_MESSAGE, blackoutDefault.getMessage());
    }
}
