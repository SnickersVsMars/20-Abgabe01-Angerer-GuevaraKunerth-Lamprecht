package at.fhj.msd;

import static org.junit.jupiter.api.Assertions.*;
import at.fhj.msd.exceptions.BlackoutException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Testing class for the class cocktail
 *
 * @author Samuel Angerer
 * @version %I%, %G%
 * @since 1.1
 */

@DisplayName("Testing Cocktail implementation")
class CocktailTest {
    /**
     * 3 lists that contain the liquids for the cocktails
     */
    private ArrayList<Liquid> m1, m2, m3;
    /**
     * 3 cocktails to be initialized
     */
    private Cocktail c1, c2, c3;
    /**
     * special liquid that is used more than once, hence declared here
     */
    private Liquid weingeist;

    /**
     * Inits a cocktails object that is non-alcoholic, a cocktails object that is alcoholic and slighltly
     * under 80% alcohol percentage and one that is above. Additionally inits 3 lists that contain the
     * liquids for the cocktails
     */
    @BeforeEach
    void setup() {
        weingeist = new Liquid("Weingeist", 0.02, 96);
        m1 = new ArrayList<>(){
            {
                add(new Liquid("Pineapplejuice", 0.2, 0.0));
                add(new Liquid("Coconutjuice", 0.1, 0.0));
                add(new Liquid("Orangejuice", 0.2, 0.0));
            }
        };
        m2 = new ArrayList<>(){
            {
                add(new Liquid("Vodka", 0.05, 70));
                add(new Liquid("Tequila", 0.05, 80));
                add(new Liquid("Stroh Rum", 0.05, 80));
                add(new Liquid("Whiskey", 0.05, 80));
            }
        };
        m3  = new ArrayList<>(){
            {
                add(new Liquid("Stroh Rum", 0.02, 80));
                add(new Liquid("Absinth", 0.02, 85));
                add(weingeist);
            }
        };
        try {
            c1 = new Cocktail("Virgin Drink", m1);
            c2 = new Cocktail("Mild Custom Headache", m2);
            c3 = new Cocktail("Why would you drink this?", m3);
        } catch (BlackoutException e) {
            e.printStackTrace();
        }

    }

    /**
     * Test for the constructor, tests if cocktails objects aare created with above values
     */
    @Test
    @DisplayName("Testing constructor")
    public void testConstructor(){
        assertEquals("Virgin Drink", c1.getName());
        assertEquals(m1, c1.getMixture());
        assertEquals("Mild Custom Headache", c2.getName());
        assertEquals(m2, c2.getMixture());
    }

    /**
     * Tests if the constructor throws the BlackoutException if cocktail to be created is above 80%
     */
    @Test
    @DisplayName("Testing if constructor throws")
    public void testConstructorThrows(){
        assertThrows(BlackoutException.class, ()->{c3 = new Cocktail("Why would you drink this?", m3);});
    }

    /**
     * Tests if the volume is properly returned
     */
    @Test
    @DisplayName("Testing volume getter")
    public void testVolumeGetter(){
        assertEquals(0.5, c1.getVolume(), 0.001);
        assertEquals(0.20, c2.getVolume(), 0.001);
    }

    /**
     * Tests if the aldohol percent is properly returned
     */
    @Test
    @DisplayName("Testing alcohol percent getter")
    public void testAlcoholPercentGetter(){
        assertEquals(0.0, c1.getAlcoholPercent(), 0.001);
        assertEquals(77.5, c2.getAlcoholPercent(), 0.001);
    }

    /**
     * Tests if isAlcoholic returns the proper boolean
     */
    @Test
    @DisplayName("Testing isAlcoholic")
    public void testIsAlcoholic(){
        assertFalse(c1.isAlcoholic());
        assertTrue(c2.isAlcoholic());
    }

    /**
     * Tests of addLiquid throws the BlackoutException properly when the liquid to be added would
     * exceed 80%
     */
    @Test
    @DisplayName("Testing if addLiquid throws")
    public void testAddLiquidThrows(){
        assertThrows(BlackoutException.class, ()->{c2.addLiquid(weingeist);});
    }

    /**
     * Tests if the liquid in addLiquid is added properly by comparing the volume of the cocktail before
     * and after adding
     */
    @Test
    @DisplayName("Testing addLiquid")
    public void testAddLiquid(){
        double volumeBefore = c1.getVolume();
        try {
            c1.addLiquid(new Liquid("Strawberrysirup", 0.1, 0.0));
        } catch (BlackoutException e) {
            e.printStackTrace();
        }
        double volumeAfter = c1.getVolume();
        assertNotEquals(volumeAfter, volumeBefore);
    }
}
