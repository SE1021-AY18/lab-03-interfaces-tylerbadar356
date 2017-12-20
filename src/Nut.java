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
 * @version 1.0 Created on 12/14/2017 at 3:29 PM.
 */

public class Nut implements Part {
    private double diameterInches;
    public static final double LBS_MULTIPLIER = 0.01;
    public static final double USD_MULTIPLIER = 0.50;
    public Nut(double diameterInches) {
        this.diameterInches = diameterInches;
    }

    @Override
    public double getCost() {
        double cost = USD_MULTIPLIER * diameterInches;
        return cost;
    }

    @Override
    public String getName() {
        return "nut";
    }

    @Override
    public double getWeight() {
        double weight = LBS_MULTIPLIER * (diameterInches * diameterInches);
        return weight;
    }

    @Override
    public void printBillOfMaterials() {
        System.out.println("====================\n" +
                diameterInches + this.getName() + "\n" +
                "====================\n" +
                "Diameter: " + diameterInches + " inches\n" +
                "Cost: $" + getCost() + "\n" +
                "Weight: " + getWeight() + " lbs\n\n");
    }
}
