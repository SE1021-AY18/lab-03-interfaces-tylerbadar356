/*
 * SE1021
 * Winter 2017-2018
 * Lab 3 - Interfaces
 * Created: 12/14/2016
 */
/**
 * SE1021 2017
 * Purpose: creates the SheetMetal object
 *
 * @author badartt
 * @version 1.0 Created on 12/14/2017 at 3:27 PM.
 */
public class SheetMetal implements Part {
    /**
     * weight multiplier
     */
    public static final double LBS_MULTIPLIER = 0.1;
    private double lengthInches;
    private double thicknessInches;
    /**
     * cost multiplier
     */
    public static final double USD_MULTIPLIER = 0.50;
    private double widthInches;

    /**
     * Constructor for SheetMetal, sets length, width, and thickness
     * @param lengthInches length in inches
     * @param widthInches width in inches
     * @param thicknessInches thickness in inches
     */
    public SheetMetal(double lengthInches, double widthInches, double thicknessInches) {
        this.lengthInches = lengthInches;
        this.widthInches = widthInches;
        this.thicknessInches = thicknessInches;
    }

    /**
     * cost multiplier times thickness times width times length
     * @return returns cost
     */
    @Override
    public double getCost() {
        double cost;
        cost = USD_MULTIPLIER * this.thicknessInches * this.widthInches * this.lengthInches;
        return cost;
    }

    /**
     * dimensions of the sheet plus sheet
     * @return returns name
     */
    @Override
    public String getName() {
        return this.lengthInches + "x" + this.widthInches + "x" + this.thicknessInches + " sheet";
    }

    /**
     * weight multiplier times thickness times width times length
     * @return returns weight
     */
    @Override
    public double getWeight() {
        double weight;
        weight = LBS_MULTIPLIER * this.thicknessInches * this.widthInches * this.lengthInches;
        return weight;
    }

    /**
     * prints the bill of materials for a sheet of metal
     */
    @Override
    public void printBillOfMaterials() {
        System.out.println("====================\n" +
                this.getName() + "\n" +
                "====================\n" +
                "Length: " + this.lengthInches + " inches\n" +
                "Width: " + this.widthInches + " inches\n" +
                "Thickness: " + this.thicknessInches + " inches\n" +
                "Cost: $" + this.getCost() + "\n" +
                "Weight: " + this.getWeight() + " lbs\n");
    }
}
