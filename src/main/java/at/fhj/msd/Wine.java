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
     * @param liquid first liquid is always Wine
     * @param isSpritzer if true adds mineral water to make a spritzer
     */
   public Wine(String name, Liquid liquid, boolean isSpritzer){
        super(name);
        this.liquids[0] = liquid;
        this.isSpritzer = isSpritzer;
    }

    /**
     * Creates Wine object without the option to turn it into a spritzer.
     *
     * @param name name of drink
     * @param liquid liquid is wine
     */
    public Wine(String name, Liquid liquid) {
       super(name);
       this.liquids[0] = liquid;
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
     * If boolean in constructor is true Liquid mineralWater will be added to Liquid[]
     *
     * @param mineralWater mineral water to make a spritzer
     */
    private void addLiquid(Liquid mineralWater) {
        if (this.isSpritzer)
            this.liquids[1] = new Liquid("mineral water", 0.2, 0);
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
        for (Liquid l : liquids)
            alcoholPercent += l.getAlcoholPercent();
        return alcoholPercent;
    }
    /**
     * Gives information if drink is alcoholic or not
     *
     * @return true because Wine is always alcoholic
     */
    @Override
    public boolean isAlcoholic() {
            return true;
    }

}


