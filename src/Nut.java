/*
 * SE1021
 * Winter 2017-2018
 * Lab 3 - Interfaces
 * Created: 12/14/2016
 */
/**
 * SE1021 2017
 * Purpose: Creates the Nut class
 *
 * @author badartt
 * @version 1.0 Created on 12/14/2017 at 3:29 PM.
 */

public class Nut implements Part {
    private double diameterInches;
    /**
     * weight multiplier
     */
    public static final double LBS_MULTIPLIER = 0.01;
    /**
     * cost multiplier
     */
    public static final double USD_MULTIPLIER = 0.50;

    /**
     * Constructor for Nut, sets the diameter
     * @param diameterInches diameter in inches of the nut
     */
    public Nut(double diameterInches) {
        this.diameterInches = diameterInches;
    }

    /**
     * gets cost by multiplying cost multiplier by the diameter
     * @return returns cost
     */
    @Override
    public double getCost() {
        double cost = USD_MULTIPLIER * diameterInches;
        return cost;
    }

    /**
     * diameter plus nut
     * @return returns name
     */
    @Override
    public String getName() {
        return diameterInches + " nut";
    }

    /**
     * weight multplier times diameter squared
     * @return returns weight
     */
    @Override
    public double getWeight() {
        double weight = LBS_MULTIPLIER * (diameterInches * diameterInches);
        return weight;
    }

    /**
     * prints bill of materials for a nut
     */
    @Override
    public void printBillOfMaterials() {
        System.out.println("====================\n" +
                this.getName() + "\n" +
                "====================\n" +
                "Diameter: " + diameterInches + " inches\n" +
                "Cost: $" + getCost() + "\n" +
                "Weight: " + getWeight() + " lbs\n");
    }
}
