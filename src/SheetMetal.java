/*
 * SE1011-061
 * Fall 2017
 * File purpose:
 * Name: Badar
 * Created: 
 */

/**
 * SE 1011-061 2017
 * Purpose: in your own words, what does this class do?
 *
 * @author badartt
 * @version 1.0 Created on 12/14/2017 at 3:27 PM.
 */
public class SheetMetal implements Part {
    public static final double LBS_MULTIPLIER = 0.1;
    private double lengthInches;
    private double thicknessInches;
    public static final double USD_MULTIPLIER = 0.50;
    private double widthInches;
    public SheetMetal(double lengthInches, double widthInches, double thicknessInches) {
        this.lengthInches = lengthInches;
        this.widthInches = widthInches;
        this.thicknessInches = thicknessInches;
    }

    @Override
    public double getCost() {
        return 0;
    }

    @Override
    public String getName() {
        return "sheet";
    }

    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public void printBillOfMaterials() {
        //some logic
    }
}
