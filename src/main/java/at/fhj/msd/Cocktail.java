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
public class Cocktail extends Drink {
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
    public Cocktail(String name, ArrayList<Liquid> mixture) throws BlackoutException {
        super(name);
        this.mixture = mixture;
        if (this.getAlcoholPercent() >= 80) {
            throw new BlackoutException();
        }
    }
    /**
     * Returns volume of cocktail
     *
     * @return the volume of the cocktail in litre
     */
    @Override
    public double getVolume() {
        double volume = 0;
        for (Liquid liquid : mixture) {
            volume += liquid.getVolume();
        }
        return volume;
    }
    /**
     * Returns alcohol volume percent of cocktail by calculating mean of the percentages of the liquids
     *
     * @return alcohol volume percent
     */
    @Override
    public double getAlcoholPercent() {
        double mean = 0;
        int counter = 0;
        for (Liquid liquid : mixture) {
            mean += liquid.getAlcoholPercent();
            counter++;
        }
        return mean/counter;
    }
    /**
     * Gives information if drink is alcoholic or not
     *
     * @return true when alcoholic liquids are present, otherwise false
     */
    @Override
    public boolean isAlcoholic() {
        for (Liquid liquid : mixture) {
            if (liquid.getAlcoholPercent() > 0){
                return true;
            }
        }
        return false;
    }
    /**
     * Method allows to add liquids at a later time, throws BlackoutException if alcohol percentage is above 80%
     *
     * @param newLiquid Liquid to be added
     */
    public void addLiquid (Liquid newLiquid) throws BlackoutException{
        mixture.add(newLiquid);
        if (this.getAlcoholPercent() >= 80){
            throw new BlackoutException();
        }
    }
    /**
     * Getter for the attribute mixture, returns the mixture of the cocktail
     */
    public ArrayList<Liquid> getMixture(){
        return mixture;
    }
}
