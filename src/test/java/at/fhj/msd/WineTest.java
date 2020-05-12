package at.fhj.msd;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *  Testing class for class Wine
 *
 * @author martin g.k.
 * @version %I%, %G%
 * @since 1.1
 */
@DisplayName("Testing Wine implementation")
class WineTest {
    private Wine w1, w2;


    /**
     * inits a Wine object without Boolean in constructor and a Wine object
     * with Boolean to test the spritzer implementation
     */
    @BeforeEach
    void setup() {
     w1 = new Wine("St. Laurent", new Liquid ("St. Laurent", 0.25, 9));
     w2 = new Wine("Veltliner", new Liquid("Gruener Veltliner", 0.15, 9), true);
    }

    /**
     * Tests if name has added suffix "spritzer"
     */
    @Test
    @DisplayName("Testing 'spritzer' suffix")
    void checkNameIsSpritzer() {
        assertEquals("Veltliner spritzer", w2.getName());
    }

    /**
     * Tests name without suffix
     */
    @Test
    @DisplayName("Testing Wine name")
    void checkName() {
        assertEquals("St. Laurent", w1.getName());
    }

    /**
     * Tests getVolume method and array access in that method
     */
    @Test
    @DisplayName("Testing volume")
    void checkVolume() {
        assertEquals(0.25, w1.getVolume());
    }

    /**
     * Tests if Wine object has alcohol content
     */
    @Test
    @DisplayName("Testing is alcoholic")
    void isAlcoholic() {
        assertTrue(w2.isAlcoholic());
    }

    /**
     * Tests alcohol percentage of Wine object
     */
    @Test
    @DisplayName("Testing alcohol percent")
    void checkAlcoholPercentage() {
        assertEquals(9, w1.getAlcoholPercent());
    }

    /**
     * Tests if added liquid is mineral water by accessing the second liquid in array
     */
    @Test
    @DisplayName("Testing if added liquid is mineral water")
    void isAddedLiquidMineralWater() {
        if (w2.liquids[1] != null)
        assertEquals("mineral water", w2.liquids[1].getName());
    }
}