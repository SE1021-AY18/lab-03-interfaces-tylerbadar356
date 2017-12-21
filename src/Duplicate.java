/*
 * SE1021
 * Winter 2017-2018
 * Lab 3 - Interfaces
 * Created: 12/14/2016
 */
import java.text.DecimalFormat;

/**
 * SE1021 2017
 * Purpose: Creates duplicate parts
 *
 * @author badartt
 * @version 1.0 Created on 12/14/2017 at 3:28 PM.
 */
public class Duplicate implements Part {
    private DecimalFormat costFormat = new DecimalFormat("$##.##");
    private Part identicalPart;
    private int numDuplicates;
    /**
     * discount for 5 parts
     */
    public static final double REDUCTION_FACTOR1 = 0.95;
    /**
     * discount for 10 parts
     */
    public static final double REDUCTION_FACTOR2 = 0.9;
    /**
     * factor for 5% discount
     */
    public static final int USD_THRESHOLD1 = 5;
    /**
     * factor for 10% discount
     */
    public static final int USD_THRESHOLD2 = 10;
    private DecimalFormat weightFormat = new DecimalFormat("##.### lbs");

    /**
     * Constructor for Duplicate, sets the part and the number of duplicates
     * @param identicalPart part to make
     * @param numDuplicates number of parts to make
     */
    public Duplicate(Part identicalPart, int numDuplicates) {
        this.identicalPart = identicalPart;
        this.numDuplicates = numDuplicates;
    }

    /**
     * gets cost by multiplying the parts cost and the number of duplicates together,
     * and also the discount if it qualifies
     * @return returns cost
     */
    @Override
    public double getCost() {
        double cost = this.identicalPart.getCost() * numDuplicates;
        if (numDuplicates >= USD_THRESHOLD1 && numDuplicates < USD_THRESHOLD2) {
            cost = cost * REDUCTION_FACTOR1;
        } else if (numDuplicates >= USD_THRESHOLD2) {
            cost = cost * REDUCTION_FACTOR2;
        }
        return cost;
    }

    /**
     * number of duplicates plus part name
     * @return returns name
     */
    @Override
    public String getName() {
        return this.numDuplicates + " " + this.identicalPart.getName();
    }

    /**
     * parts weight and number of parts multiplied
     * @return returns weight
     */
    @Override
    public double getWeight() {
        return this.identicalPart.getWeight() * numDuplicates;
    }

    /**
     * prints the bill for the duplicates, and then the part that was duplicated
     */
    @Override
    public void printBillOfMaterials() {
        System.out.println("====================\n" + this.getName() + "s\n====================\n" +
                "Duplicate part: " + this.getName().substring(3,this.getName().length()) + "\n" +
                "Copies: " + numDuplicates + "\n" +
                "Individual cost: " + costFormat.format(this.identicalPart.getCost()) + "\n" +
                "Individual weight: " + weightFormat.format(this.identicalPart.getWeight()) + "\n\n" +
                "Total cost: " + this.costFormat.format(this.getCost()) + "\n" +
                "Total weight: " + this.weightFormat.format(this.getWeight()) + "\n");
        this.identicalPart.printBillOfMaterials();
    }
}
