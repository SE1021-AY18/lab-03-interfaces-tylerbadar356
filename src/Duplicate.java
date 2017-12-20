import java.text.DecimalFormat;

/**
 * SE 1021 2017
 * Purpose: in your own words, what does this class do?
 *
 * @author badartt
 * @version 1.0 Created on 12/14/2017 at 3:28 PM.
 */
public class Duplicate implements Part {
    private DecimalFormat costFormat = new DecimalFormat("$00.00");
    private Part identicalPart;
    private int numDuplicates;
    public static final double REDUCTION_FACTOR1 = 0.95;
    public static final double REDUCTION_FACTOR2 = 0.9;
    public static final int USD_THRESHOLD1 = 5;
    public static final int USD_THRESHOLD2 = 10;
    private DecimalFormat weightFormat = new DecimalFormat("00.000 lbs");
    public Duplicate(Part identicalPart, int numDuplicates) {
        this.identicalPart = identicalPart;
        this.numDuplicates = numDuplicates;
    }

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

    @Override
    public String getName() {
        return this.identicalPart.getName();
    }

    @Override
    public double getWeight() {
        return this.identicalPart.getWeight() * numDuplicates;
    }

    @Override
    public void printBillOfMaterials() {
        System.out.println("====================\n" +
                "Part: " + this.numDuplicates + " " + this.getName() + "s\n" +
                "Cost: " + this.costFormat.format(this.getCost()) + "\n" +
                "Weight: " + this.weightFormat.format(this.getWeight()) + "\n\n");
    }
}
