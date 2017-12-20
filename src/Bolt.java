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
 * @version 1.0 Created on 12/14/2017 at 3:28 PM.
 */
public class Bolt implements Part {
    private double diameterInches;
    public static final double LBS_MULTIPLIER = 0.05;
    private double lengthInches;
    public static final double USD_MULTIPLIER = 1.00;
    public Bolt(double diameterInches, double lengthInches) {
        this.diameterInches = diameterInches;
        this.lengthInches = lengthInches;
    }

    @Override
    public double getCost() {
        double cost = USD_MULTIPLIER * diameterInches * lengthInches;
        return cost;
    }

    @Override
    public String getName() {
        return "bolt";
    }

    @Override
    public double getWeight() {
        double weight = LBS_MULTIPLIER * (diameterInches * diameterInches) * lengthInches;
        return weight;
    }

    @Override
    public void printBillOfMaterials() {
        System.out.println("====================\n" +
                diameterInches + "x" + lengthInches + this.getName() + "\n" +
                "====================\n" +
                "Diameter: " + diameterInches + " inches\n" +
                "Length: " + lengthInches + " inches\n" +
                "Cost: $" + getCost() + "\n" +
                "Weight: " + getWeight() + " lbs\n\n");

    }
}
