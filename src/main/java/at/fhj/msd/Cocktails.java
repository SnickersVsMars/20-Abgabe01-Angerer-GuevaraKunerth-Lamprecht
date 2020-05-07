package at.fhj.msd;

import at.fhj.msd.exceptions.BlackoutException;
import java.util.ArrayList;

/**
 * Class represents a Cocktail which consists of more than one liquid
 * Liquids can also be added  at a later time
 *
 * @author Samuel Angerer
 * @version %I%, %G%
 * @since 1.1
 */
public class Cocktails extends Drink {
    /**
     * List which contains all liquids of the cocktail
     */
    protected ArrayList<Liquid> mixture;
    /**
     * Creates a Cocktail object with given name and mixture of liquids
     *
     * @param name Name  of the Cocktail
     * @param mixture Combination of liquids the cocktail contains
     */
    public Cocktails (String name, ArrayList<Liquid> mixture) throws BlackoutException {
        super(name);
    }
    /**
     * Returns volume of cocktail
     *
     * @return the volume of the cocktail in litre
     */
    @Override
    public double getVolume() {
        return 0;
    }
    /**
     * Returns alcohol volume percent of cocktail by calculating mean od the percentages of the liquids
     *
     * @return alcohol volume percent
     */
    @Override
    public double getAlcoholPercent() {
        return 0;
    }
    /**
     * Gives information if drink is alcoholic or not
     *
     * @return true when alcoholic liquids are present, otherwise false
     */
    @Override
    public boolean isAlcoholic() {
        return false;
    }
    /**
     * Method allows to add liquids at a later time, throws BlackoutException if alcohol percentage is above 80%
     *
     * @param newLiquid Liquid to be added
     */
    public void addLiquid (Liquid newLiquid) throws BlackoutException{}
}
