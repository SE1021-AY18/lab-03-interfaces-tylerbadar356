/*
 * SE1021
 * Winter 2017-2018
 * Lab 3 - Interfaces
 * Created: 12/14/2016
 */
/**
 * SE1021 2017
 * Purpose: Creates a bolt object which implements the Part interface
 *
 * @author badartt
 * @version 1.0 Created on 12/14/2017 at 3:28 PM.
 */
public class Bolt implements Part {
    private double diameterInches;
    /**
     * the constant for calculating the weight
     */
    public static final double LBS_MULTIPLIER = 0.05;
    private double lengthInches;
    /**
     * the constant for calculating the cost
     */
    public static final double USD_MULTIPLIER = 1.00;

    /**
     * Constructor for the Bolt class, sets diameter and length
     * @param diameterInches the diameter of the bolt, in inches
     * @param lengthInches the length of the bolt, in inches
     */
    public Bolt(double diameterInches, double lengthInches) {
        this.diameterInches = diameterInches;
        this.lengthInches = lengthInches;
    }

    /**
     * calculates the cost of the bolt by multiplying
     * the diameter, the length and the cost multiplier together
     * @return returns cost calculated
     */
    @Override
    public double getCost() {
        double cost = USD_MULTIPLIER * diameterInches * lengthInches;
        return cost;
    }

    /**
     * the dimensions of the name plus bolt
     * @return returns the name
     */
    @Override
    public String getName() {
        return diameterInches + "x" + lengthInches + " bolt";
    }

    /**
     * calculates the weight by multiplying the diameter squared,
     * the length and the weight multiplier together
     * @return returns the weight calculated
     */
    @Override
    public double getWeight() {
        double weight = LBS_MULTIPLIER * (diameterInches * diameterInches) * lengthInches;
        return weight;
    }

    /**
     * prints the bill of materials for a bolt
     */
    @Override
    public void printBillOfMaterials() {
        System.out.println("====================\n" +
                this.getName() + "\n" +
                "====================\n" +
                "Diameter: " + diameterInches + " inches\n" +
                "Length: " + lengthInches + " inches\n" +
                "Cost: $" + getCost() + "\n" +
                "Weight: " + getWeight() + " lbs\n");

    }
}
