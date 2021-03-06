package at.fhj.msd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *  Testing class for class SimpleDrink
 *
 * @author Michael Lamprecht
 * @version %I%, %G%
 * @since 1.1
 */
@DisplayName("Testing SimpleDrink implementation")
public class SimpleDrinkTest {
    private SimpleDrink alcohol, nonalcohol;

    /**
     * inits an alcoholic and nonalcoholic SimpleDrink for EACH test
     */
    @BeforeEach
    void setup() {
        // SETUP PHASE
        alcohol= new SimpleDrink("Stiegl", new Liquid("Bier",0.5,4.5));
        nonalcohol = new SimpleDrink("Frucade", new Liquid("Limonade",1.5, 0));
    }

    /**
     * Method tests the correct assignment of the private fields for an alcoholic drink just after the constructor initialization
     */
    @Test
    @DisplayName("Testing constructor alcoholic")
    public void testConstructorAlcoholic(){
        assertEquals("Stiegl", alcohol.getName());
        assertEquals(0.5, alcohol.getVolume(), 0.001);
        assertEquals(4.5, alcohol.getAlcoholPercent(), 0.001);
        assertTrue(alcohol.isAlcoholic());
    }

    /**
     * Method tests the correct assignment of the private fields for a nonalcoholic drink just after the constructor initialization
     */
    @Test
    @DisplayName("Testing constructor non alcoholic")
    public void testConstructorNonAlcoholic(){
        assertEquals("Frucade",nonalcohol.getName());
        assertEquals(1.5, nonalcohol.getVolume(), 0.001);
        assertEquals(0, nonalcohol.getAlcoholPercent(), 0.001);
        assertFalse(nonalcohol.isAlcoholic());
    }
}