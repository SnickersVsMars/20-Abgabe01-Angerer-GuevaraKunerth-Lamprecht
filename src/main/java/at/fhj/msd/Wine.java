package at.fhj.msd;

/**
 * The class Wine is an implementation of the abstract class Drinks.
 * It contains one kind of Liquid and if provided can be changed into a spritzer.
 *
 * @author martin g.k.
 * @version %I%, %G%
 * @since 1.1
 */
public class Wine extends Drink {

    /**
     * Contains all of the Liquids of the class
     * Uses one liquid unless boolean in constructor is true
     */
    protected Liquid[] liquids = new Liquid[2];

    /**
     * Defines if wine will be served as spritzer or as wine
     */
    protected Boolean isSpritzer = false;

    /**
     * Creates a Wine object with given name and liquid
     *
     * @param name name of drink
     * @param liquid first liquid
     * @param isSpritzer if true adds mineral water to make a spritzer
     */
   public Wine(String name, Liquid liquid, boolean isSpritzer){
        super(name);
        this.liquids[0] = liquid;
        this.isSpritzer = isSpritzer;
       if (this.isSpritzer)
           this.liquids[1] = new Liquid("mineral water", 0.2, 0);
    }

    /**
     * Creates Wine object without the option to turn it into a spritzer.
     *
     * @param name name of drink
     * @param liquid liquid is wine
     */
    public Wine(String name, Liquid liquid) {
        this(name,liquid,false);
    }

    /**
     * Overrides getName from Drink if isSpritzer is true
     *
     * @return name of Drink. If isSpritzer = true, suffix "spritzer" will be added.
     */
    @Override
    public String getName() {
        if (this.isSpritzer)
            return name + " spritzer";
        return name;
    }

    /**
     * Returns volume of liquid l
     *
     * @return the volume of drink in litre
     */
    @Override
    public double getVolume() {
        double volume = 0;
        for (Liquid l : liquids)
            if(l != null)
                volume += l.getVolume();
        return volume;
    }

    /**
     * Returns alcohol volume percent of liquid l
     *
     * @return alcohol volume percent
     */
    @Override
    public double getAlcoholPercent() {
        double alcoholPercent = 0;
        int nrLiquids = 0;
        for (Liquid l : liquids)
            if(l != null) {
                alcoholPercent += l.getAlcoholPercent();
                nrLiquids++;
            }
        return alcoholPercent/nrLiquids;
    }

    /**
     * Gives information if drink is alcoholic or not
     *
     * @return true if alcohol percentage is > 0
     */
    @Override
    public boolean isAlcoholic() {
        return getAlcoholPercent() > 0;
    }

}


