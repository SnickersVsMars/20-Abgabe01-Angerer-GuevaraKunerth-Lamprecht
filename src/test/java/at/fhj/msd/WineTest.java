package at.fhj.msd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("Testing is Spritzer")
    void checkNameIsSpritzer() {
        assertEquals("Veltliner spritzer", w2.getName());
    }

    @Test
    @DisplayName("Testing volume")
    void checkVolume() {
        assertEquals(0.2, w1.getVolume());
    }

    @Test
    @DisplayName("Testing is alcoholic")
    void isAlcoholic() {
        assertTrue(w2.isAlcoholic());
    }

    @Test
    @DisplayName("Testing alcohol percent")
    void checkAlcoholPercentage() {
        assertEquals(9, w1.getAlcoholPercent());
    }
    @Test
    @DisplayName("Testing if added liquid is mineral water")
    void isAddedLiquidMineralWater() {
        assertEquals("mineral water", w2.liquids[1].getName());
    }
}